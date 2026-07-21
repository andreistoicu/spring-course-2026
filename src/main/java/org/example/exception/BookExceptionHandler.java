package org.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookExceptionHandler {

    @ExceptionHandler(NoBookFoundException.class)
    public ResponseEntity handleBookNotFoundException() {
        BookExceptionMessage bookExceptionMessage = new BookExceptionMessage(404,
                "Book not found",
                "Book not found description");
        return new ResponseEntity(bookExceptionMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoBookFoundForDeleteException.class)
    public ResponseEntity handleBookNotFoundForDeleteException() {
        BookExceptionMessage bookExceptionMessage = new BookExceptionMessage(404,
                "delete",
                "Book not found for deeletion description");
        return new ResponseEntity(bookExceptionMessage, HttpStatus.NOT_FOUND);
    }

    /*@ExceptionHandler(Exception.class)
    public ResponseEntity handleGeneralException() {
        return new ResponseEntity(bookExceptionMessage, HttpStatus.NOT_FOUND);
    }*/
}
