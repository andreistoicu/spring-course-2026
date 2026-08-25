package org.example.controller;

import org.example.dao.entity.Book;
import org.example.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/books")
public class AdminBookController {

    private final BookService bookService;

    public AdminBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books/")
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());

        model.addAttribute("newBook", new Book());

        return "admin-books";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute("newBook") Book book){
        bookService.saveBook(book);
        return "redirect:/admin/books";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id){
        bookService.deleteBook(id);
        return "redirect:/admin/books";
    }

}
