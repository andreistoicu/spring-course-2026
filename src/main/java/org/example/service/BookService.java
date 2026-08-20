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

    public List<Book> findAll() {
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

    public Book save(Book book, Long authorId, Long categoryId) {
        if(bookRepository.findById(book.getId()) == null) {
            bookRepository.save(book);
        } else {
            throw new IllegalArgumentException("Book already exists");
        }

        return bookRepository.save(book);
    }

    public Book update(){
        return null;
    }

    public void delete(Long id) {
        Book book = findById(id);
        if(book == null) {
            throw new IllegalArgumentException("Book not found");
        }

        bookRepository.deleteById(id);
    }
}
