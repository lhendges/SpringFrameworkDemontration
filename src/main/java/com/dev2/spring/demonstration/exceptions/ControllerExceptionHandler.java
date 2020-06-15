package com.dev2.spring.demonstration.exceptions;

import com.dev2.spring.demonstration.dto.ExceptionDefaultResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ExceptionDefaultResponseDto> handleRuntimeExceptions(RuntimeException exception) {
        ExceptionDefaultResponseDto dto = ExceptionDefaultResponseDto.builder()
                .handlerMessage("Ocorreu um erro e ele foi tratado pelo ExceptionHandler")
                .exceptionMessage(exception.getMessage())
                .build();
        return ResponseEntity.status(500)
                .body(dto);
    }
}
