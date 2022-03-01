package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ReponseError handlerNotFoundException(NotFoundException e, WebRequest req) {
        return new ReponseError("Not found", e.getMessage());
    }

    @ExceptionHandler(FailedException.class)
    @ResponseStatus(HttpStatus.FAILED_DEPENDENCY)
    public ReponseError handlerFailedException(FailedException e, WebRequest req) {
        return new ReponseError("Failed", e.getMessage());
    }


    @ExceptionHandler(Exception.class)
    public ReponseError handlerException(Exception e, WebRequest request) {
        return new ReponseError("Failed", e.getMessage());
    }
}
