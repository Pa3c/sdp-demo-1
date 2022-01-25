package com.sdp.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SimpleExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(CustomServerException.class)
    public ResponseEntity<String> errorResponse (CustomServerException e) {
        return ResponseEntity //
                .status(HttpStatus.INTERNAL_SERVER_ERROR) //
                .body(e.getMessage()); //
    }
}
