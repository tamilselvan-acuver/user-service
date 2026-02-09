package com.acuver.userservice.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleUserNotFound(UserNotFoundException exception) {
        Map<String, Object> error = new HashMap<>();
        error.put("status", 404);
        error.put("message", exception.getMessage());
        error.put("timestamp", LocalDateTime.now());
        return ResponseEntity.status(404).body(error);
    }
}
