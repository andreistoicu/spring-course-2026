package org.example.service;

import org.example.dao.BookJPARepository;
import org.example.dao.entity.Author;
import org.example.dao.entity.Book;
import org.example.exception.NoBookFoundForDeleteException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookJPARepository bookJPARepository;

    @InjectMocks
    private BookService bookService;

    @Test
    void findBookByReturnsBookWhenItExists(){
        Author author = new Author();
        author.setName("Mircea Eliade");
        author.setCountry("ROM");

        Book book = new Book();
        book.setTitle("Filosofie generala");
        book.setPrice(923.0);
        book.setAuthor(author);
        book.setId(923L);

        when(bookJPARepository.findById(923L))
                .thenReturn(Optional.of(book));

        Book result = bookService.findBookById(923L);

        assertSame(book, result);

        verify(bookJPARepository).findById(923L);
    }

    @Test
    void deleteBookByIdThrowsExceptionWhenBookDoesNotExist(){
        when(bookJPARepository.findById(77L))
                .thenReturn(Optional.empty());

        NoBookFoundForDeleteException exception = assertThrows(
                NoBookFoundForDeleteException.class,
                () -> bookService.deleteBook(77L)
        );

        assertEquals("Book with id:77 not found to be deleted!" , exception.getMessage());
    }

    @Test
    void deleteBookReturns200WhenBookExists(){
        Author author = new Author();
        author.setName("Alex Dumas");
        author.setCountry("FR");

        Book book = new Book();
        book.setTitle("Pardaillan");
        book.setPrice(923.0);
        book.setAuthor(author);
        book.setId(100L);

        when(bookJPARepository.findById(100L))
                .thenReturn(Optional.of(book));

        bookService.deleteBook(100L);

        verify(bookJPARepository)
                .deleteById(100L);
    }
}
