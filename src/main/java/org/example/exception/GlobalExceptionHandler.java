package org.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public String handleGeneralException(Exception ex, Model model) {
        populateErrorModel(model, HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return "error";
    }

    private void populateErrorModel(Model model, HttpStatus status, String message) {
        model.addAttribute("status", status.value());
        model.addAttribute("error", status.getReasonPhrase());
        model.addAttribute("message", message);
    }
}
