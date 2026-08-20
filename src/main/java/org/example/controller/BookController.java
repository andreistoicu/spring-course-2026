package org.example.controller;

import org.example.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books/")
    public String getAllBooks(@RequestParam(required = false) String title ,
                              Model model) {
        model.addAttribute("books", bookService.findByTitle(title));

        model.addAttribute("title", title);

        return "books/list";
    }

}
