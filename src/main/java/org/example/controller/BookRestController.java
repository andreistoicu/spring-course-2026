package org.example.controller;

import org.example.dao.entity.Book;
import org.example.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookRestController {

    private BookService bookService;

    public BookRestController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("")
    public List<Book> getAllBooks() {
        return null;
    }

    @GetMapping("/{id}")
    //public Book getBookById(@PathVariable("id") Long idBook) { -> varianta in care vrem sa folosim un nume
    // de variabla diferit de id (ex:idBook)
    public Book getBookById(@PathVariable Long id) {
        return null;
    }

    @PostMapping("/add")
    public void addBook(@RequestBody Book book) {
        bookService.saveBook(book);
    }

    @PutMapping("/{id}")
    public void updateBook(@PathVariable Long id, @RequestBody Book book) {

    }

    @DeleteMapping("/{id}")
    public void deleteBookById(){

    }
}
