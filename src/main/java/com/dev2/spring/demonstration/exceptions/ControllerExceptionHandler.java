package com.dev2.spring.demonstration.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<String> handleRuntimeExceptions(RuntimeException exception) {
        return ResponseEntity.status(500)
                .body("Ocorreu um erro e ele foi tratado pelo ExceptionHandler");
    }
}
