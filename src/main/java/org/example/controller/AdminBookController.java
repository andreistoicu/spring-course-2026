package org.example.controller;

import org.example.dao.entity.Author;
import org.example.dao.entity.Book;
import org.example.service.AuthorService;
import org.example.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminBookController {

    private final BookService bookService;
    private final AuthorService authorService;

    public AdminBookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    // Books Management
    @GetMapping("/books")
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        model.addAttribute("newBook", new Book());
        model.addAttribute("authors", authorService.getAllAuthors());
        model.addAttribute("newAuthor", new Author());
        return "admin-books";
    }

    @PostMapping("/books/save")
    public String saveBook(@ModelAttribute("newBook") Book book){
        bookService.saveBook(book);
        return "redirect:/admin/books";
    }

    @GetMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id){
        bookService.deleteBook(id);
        return "redirect:/admin/books";
    }

    // Authors Management
    @GetMapping("/authors")
    public String listAuthors(Model model) {
        model.addAttribute("authors", authorService.getAllAuthors());
        model.addAttribute("newAuthor", new Author());
        return "admin-authors";
    }

    @PostMapping("/authors/save")
    public String saveAuthor(@ModelAttribute("newAuthor") Author author) {
        authorService.saveAuthor(author);
        return "redirect:/admin/books";
    }

    @GetMapping("/authors/delete/{id}")
    public String deleteAuthor(@PathVariable("id") Long id) {
        authorService.deleteAuthor(id);
        return "redirect:/admin/books";
    }

}