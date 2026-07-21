package org.example.service;

import org.example.dao.BookJPARepository;
import org.example.dao.entity.Book;
import org.example.exception.NoBookFoundException;
import org.example.exception.NoBookFoundForDeleteException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    BookJPARepository bookJPARepository;

    public BookService(BookJPARepository bookJPARepository) {
        this.bookJPARepository = bookJPARepository;
    }

    public void saveBook(Book book){
        bookJPARepository.save(book);
    }

    public List<Book> findAllBooks(){
        return bookJPARepository.findAll();
    }

    public Book findBookById(Long id){
        return bookJPARepository.findById(id)
                .orElseThrow(() -> new NoBookFoundForDeleteException("Book with id:" + id + " not found !"));
    }

    public Book updateBook(Book book){
        return bookJPARepository.save(book);
    }

    public void deleteBook(Long id){
        bookJPARepository.findById(id)
                .orElseThrow(() -> new NoBookFoundForDeleteException("Book with id:" + id + " not found to be deleted!"));

        bookJPARepository.deleteById(id);
    }
}
