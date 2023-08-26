package com.br.ecommercebook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class Handler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleRunTimeException(
            Exception exception) {
        return getObjectResponseEntity(
                exception.getMessage(),
                "Server died",
                exception,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleRunTimeException(
            RuntimeException exception) {
        return getObjectResponseEntity(
                exception.getMessage(),
                "An error happened",
                exception,
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(
            UserNotFoundException ex, WebRequest request) {

        return getObjectResponseEntity(
                ex.getMessage(),
                "User does not exist in the system",
                ex,
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AddressNotFoundException.class)
    public ResponseEntity<Object> handleAddressNotFoundException(
            UserNotFoundException ex, WebRequest request) {

        return getObjectResponseEntity(
                ex.getMessage(),
                "Address does not exist in the system",
                ex,
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoMainAddressDefinedException.class)
    public ResponseEntity<Object> handleNoMainAddressDefinedException(
            NoMainAddressDefinedException ex, WebRequest request) {

        return getObjectResponseEntity(
                ex.getMessage(),
                "No main address was defined!",
                ex,
                HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Object> getObjectResponseEntity(String message, Object cause, Exception ex, HttpStatus httpStatus) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", message);
        body.put("returned", cause);
        body.put("time", new Date().toString());

        return new ResponseEntity<>(body, httpStatus);
    }
}
