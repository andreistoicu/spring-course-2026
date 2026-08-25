package org.example.controller;

import org.example.dao.entity.Book;
import org.example.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user/books")
public class UserBookController {

    private final BookService bookService;

    public UserBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String searchBooks(@RequestParam(value = "query", required = false) String query, Model model){
        List<Book> books = bookService.searchBooks(query);
        model.addAttribute("books", books);
        model.addAttribute("query", query);
        return "user-books";
    }

    @PostMapping("/borrow/{id}")
    public String borrowBook(@PathVariable("id") Long id){
        bookService.borrowBook(id);
        return "redirect:/user/books";
    }

    @PostMapping("/return/{id}")
    public String returnBook(@PathVariable("id") Long id){
        bookService.returnBook(id);
        return "redirect:/user/books";
    }
}
