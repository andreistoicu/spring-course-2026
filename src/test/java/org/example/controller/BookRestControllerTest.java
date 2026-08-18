package org.example.controller;

import org.example.dao.BookJPARepository;
import org.example.dao.entity.Author;
import org.example.dao.entity.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc // enables MockMvc injectat mai jos
public class BookRestControllerTest {

    //injecteaja un repository cu ajutorul @Autowired
    @Autowired
    private BookJPARepository bookJPARepository;

    @Autowired
    private MockMvc mockMvc;

    //facem un clean la fiecare test
    @BeforeEach
    void cleanDatabase() {
        bookJPARepository.deleteAll();
    }

    //region testare
    @Test
    void getAllBooksReturnsNotFoundANyBook() throws Exception {
        mockMvc.perform(get("/books"))
                .andExpect(status().isNotFound());
    }

    @Test
    void getAllBooksReturnsBooks() throws Exception {
        Author author = new Author();
        author.setName("Mihai Eminescu");
        author.setCountry("ROM");

        Book book = new Book();
        book.setTitle("Clean code");
        book.setPrice(123.0);
        book.setAuthor(author);

        bookJPARepository.save(book);

        mockMvc.perform(get("/books"))
                .andExpect(status().isOk());
    }

    @Test
    void getBookByIdReturnsNotFound() throws Exception {
        mockMvc.perform(get("/books/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void deleteBookRemoveBook() throws Exception{
        Author author = new Author();
        author.setName("Mihai Eminescu");
        author.setCountry("ROM");

        Book book = new Book();
        book.setTitle("Clean code");
        book.setPrice(123.0);
        book.setAuthor(author);

        Book bookSaved = bookJPARepository.save(book);

        mockMvc.perform(delete("/books/" + bookSaved.getId()))
                .andExpect(status().isOk());

        mockMvc.perform(get("/books/"+ bookSaved.getId()))
                .andExpect(status().isNotFound());
    }

    //endregion

}
