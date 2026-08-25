package org.example.service;

import org.example.dao.BookRepository;
import org.example.dao.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Admin zone
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> searchBooks(String query){
        if (query != null && !query.trim().isEmpty()){
            return bookRepository.searchByTitleOrAuthor(query);
        }
        return bookRepository.findAll();
    }


    public Book findById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));
    }


    public List<Book> findByTitle(String title) {
        if (title == null || title.isBlank()) {
            return bookRepository.findAll();
        }

        return bookRepository.findByTitleIgnoreCase(title);
    }

    public Book saveBook(Book book) {
        if(book.getId() == null) {
            book.setAvailableCopies(book.getTotalCopies());
        }

        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        Book book = findById(id);
        if(book == null) {
            throw new IllegalArgumentException("Book not found");
        }

        bookRepository.deleteById(id);
    }

    // User zone
    public void borrowBook(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found with id: " + id + ""));

        if(book.getAvailableCopies() > 0) {
            book.setAvailableCopies(book.getAvailableCopies() - 1);
            bookRepository.save(book);
        } else {
            throw new IllegalStateException("No available copies to borrow");
        }
    }
    public void returnBook(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found with id: " + id + ""));

        if(book.getAvailableCopies() < book.getTotalCopies()) {
            book.setAvailableCopies(book.getAvailableCopies() + 1);
            bookRepository.save(book);
        } else {
            throw new IllegalStateException("All copies are already returned");
        }
    }
}
