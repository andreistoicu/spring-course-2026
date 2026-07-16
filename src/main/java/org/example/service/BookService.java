package org.example.service;

import org.example.dao.BookJPARepository;
import org.example.dao.entity.Book;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    BookJPARepository bookJPARepository;

    public BookService(BookJPARepository bookJPARepository) {
        this.bookJPARepository = bookJPARepository;
    }

    public void saveBook(Book book){
        bookJPARepository.save(book);
    }
}
