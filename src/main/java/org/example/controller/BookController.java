package org.example.controller;

import jakarta.annotation.PostConstruct;
import org.example.dao.entity.Book;
import org.example.service.BookService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostConstruct
    void init(){
        Book book1 = new Book();
        book1.setTitle("Count of Monte Cristo");
        book1.setPrice(89.99);
        System.out.println("Saving book: " + book1);
        //bookService.saveBook(book1);

        Book book2 = new Book();
        book2.setTitle("Ion");
        book2.setPrice(39.99);
        System.out.println("Saving book: " + book2);
        //bookService.saveBook(book2);

        List<Book> foundBooks = bookService.findAll();

        for(Book book : foundBooks){
            System.out.println("Found books: " + book);
        }

    }
}
