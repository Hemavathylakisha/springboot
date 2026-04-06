package com.Bank.BankingApplication.ExceptionHandling;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ExceptionResponseDTO> handleRuntime(RuntimeException e, HttpServletRequest request) {
        ExceptionResponseDTO error=ExceptionResponseDTO.builder()
                .timesatamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value()) // return status in response body
                .message(e.getMessage())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> handleBadRequest(BadRequestException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    //check duplicate
    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<String> handleBadRequest(DuplicateResourceException e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    //check duplicate
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleBadRequest(ResourceNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    //Bean validation
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e)
    {
        Map<String, String> errorMap = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(fieldError -> fieldError.getField(), fieldError -> fieldError.getDefaultMessage(), (oldV, newV)-> oldV+" , "+newV));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
    }
}

