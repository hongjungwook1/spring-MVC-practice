package com.example.demo.exceptionHandler;

import com.example.demo.member.exception.CustomException;
import com.example.demo.member.exception.ExceptionType;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CustomMemberExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorDetail> handler(HttpServletRequest request, CustomException e) {
        ExceptionType type = e.getType();
        HttpStatus status = type.getStatus();

        ErrorDetail detail = ErrorDetail.builder()
                .error(e.getMessage())
                .path(request.getRequestURI())
                .status(status.value())
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(status).body(detail);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorDetail> handler(HttpServletRequest request, Exception e) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        ErrorDetail detail = ErrorDetail.builder()
                .error(e.getMessage())
                .path(request.getRequestURI())
                .status(status.value())
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(status).body(detail);
    }


}
