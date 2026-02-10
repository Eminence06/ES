package com.expensetracker.es.exceptions;

import com.expensetracker.es.dto.ApiError;
import com.expensetracker.es.exceptions.customException.BadException;
import com.expensetracker.es.exceptions.customException.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionalHandler {

    @ExceptionHandler(BadException.class)
    public ResponseEntity<ApiError> handleBadException(BadException ex, HttpServletRequest request){
        ApiError error = ApiError.builder()
                .timestamp(LocalDateTime.now())
                .status(400)
                .error("BAD REQUEST")
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(ResourceNotFoundException ex, HttpServletRequest request){
        ApiError error = ApiError.builder()
                .timestamp(LocalDateTime.now())
                .status(404)
                .error("NOT FOUND")
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .build();
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
