package com.giannis.usermanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handleRuntimeException(RuntimeException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        String errorLabel = "Server Error";

        if (ex.getMessage().contains("not found")) {
            status = HttpStatus.NOT_FOUND;
            errorLabel = "Not Found";
        } else if (ex.getMessage().contains("already exists")) {
            status = HttpStatus.CONFLICT;
            errorLabel = "Conflict";
        }

        body.put("status", status.value());
        body.put("error", errorLabel);
        body.put("message", ex.getMessage());
        System.out.println("Exception caught: " + ex.getMessage());

        return new ResponseEntity<>(body, status);
    }
}