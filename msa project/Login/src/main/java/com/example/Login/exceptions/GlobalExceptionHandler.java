package com.example.Login.exceptions;

import com.example.Login.payloadresponse.LoginMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<LoginMessage> handlerResourceNotFoundException(ResourceNotFoundException ex){
        String message = ex.getMessage();
        LoginMessage response = LoginMessage.builder().message(message).status(true).check(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<LoginMessage> (response, HttpStatus.NOT_FOUND);
    }
}
