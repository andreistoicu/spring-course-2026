package org.example.service;

import org.example.dao.BookJPARepository;
import org.example.dao.entity.Book;
import org.example.dao.entity.Chapter;
import org.example.exception.NoBookFoundException;
import org.example.exception.NoBookFoundForDeleteException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {

    BookJPARepository bookJPARepository;

    public BookService(BookJPARepository bookJPARepository) {
        this.bookJPARepository = bookJPARepository;
    }

    @Transactional
    public void saveBook(Book book){
        //face setarea a fieacarui capitol ca sa il asigneze pe cartea creata
        if (book.getChapters() != null) {
            book.getChapters().forEach(ch -> ch.setBook(book));
        }
        bookJPARepository.save(book);
    }

    public List<Book> findAllBooks(){
        return bookJPARepository.findAll();
    }

    public Book findBookById(Long id){
        return bookJPARepository.findById(id)
                .orElseThrow(() -> new NoBookFoundForDeleteException("Book with id:" + id + " not found !"));
    }

    @Transactional
    public Book updateBook(Book book, Long id){
        Long bookId = book.getId();

        Book existingBook = bookJPARepository.findById(bookId)
                .orElseThrow(() -> new NoBookFoundException("Book with id:" + id + " not found !"));

        existingBook.setTitle(book.getTitle());
        existingBook.setPrice(book.getPrice());
        existingBook.setAuthor(book.getAuthor());

        existingBook.getChapters().clear();

        if (book.getChapters() != null) {
            for(Chapter chapter : book.getChapters()){
                chapter.setBook(book);
                existingBook.getChapters().add(chapter);
            }
        }

        //bookJPARepository.updateBookById(id, book.getPrice(), book.getTitle());
        bookJPARepository.save(existingBook);
        return book;
    }

    public void deleteBook(Long id){
        bookJPARepository.findById(id)
                .orElseThrow(() -> new NoBookFoundForDeleteException("Book with id:" + id + " not found to be deleted!"));

        bookJPARepository.deleteById(id);
    }
}
