package org.example.service;

import jakarta.transaction.Transactional;
import org.example.dao.BookRepository;
import org.example.dao.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public void saveBook(Book book){
        bookRepository.saveBook(book);
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }
}
