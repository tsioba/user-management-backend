package com.giannis.usermanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handleRuntimeException(RuntimeException ex) {


        // Φτιάχνουμε το "σώμα" (body) της απάντησης
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());

        String errorMessage = ex.getMessage();

        // Περίπτωση 1: Δεν βρέθηκε ο χρήστης
        if (errorMessage != null && errorMessage.contains("Δεν βρέθηκε")) {
            body.put("status", 404);
            body.put("error", "Not Found");
            System.out.println("Σφάλμα: " + errorMessage);

            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        }

        // Περίπτωση 2: Ο χρήστης υπάρχει ήδη (από την αποθήκευση)
        else if (errorMessage != null && errorMessage.contains("υπάρχει ήδη")) {
            body.put("status", 409);
            body.put("error", "Conflict");
            System.out.println("Σφάλμα: " + errorMessage);

            return new ResponseEntity<>(body, HttpStatus.CONFLICT);
        }

        // Περίπτωση 3: Το όνομα χρησιμοποιείται ήδη (από την ενημέρωση)
        else if (errorMessage != null && errorMessage.contains("χρησιμοποιείται ήδη")) {
            body.put("status", 409);
            body.put("error", "Conflict");
            System.out.println("Σφάλμα: " + errorMessage);

            return new ResponseEntity<>(body, HttpStatus.CONFLICT);
        }

        // Περίπτωση 4: Οποιοδήποτε άλλο άγνωστο σφάλμα
        else {
            body.put("status", 500);
            body.put("error", "Internal Server Error");
            System.out.println("Σφάλμα: " + errorMessage);

            return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}