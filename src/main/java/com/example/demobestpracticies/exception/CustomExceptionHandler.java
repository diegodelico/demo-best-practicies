package com.example.demobestpracticies.exception;

import com.example.demobestpracticies.dto.ErrorResponseDTO;
import feign.FeignException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.time.format.DateTimeParseException;

@RestControllerAdvice
public class CustomExceptionHandler {

    @Order(1)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> handleValidationException(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        ErrorResponseDTO errorResponse = new ErrorResponseDTO("Validation Error", "400", "", result.getFieldErrors());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
    @Order(2)
    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<ErrorResponseDTO> handleDateTimeParseException(DateTimeParseException ex) {
        ErrorResponseDTO errorResponse =
                new ErrorResponseDTO("Validation Error", "400", ex.getMessage(), null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
    @Order(3)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponseDTO> handleDateTimeParseException(ConstraintViolationException ex) {
        ErrorResponseDTO errorResponse =
                new ErrorResponseDTO("Validation Error", "400", ex.getMessage(), null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @Order(4)
    @ExceptionHandler(FeignException.FeignClientException.class)
    public ResponseEntity<ErrorResponseDTO> handleFeignClientExceptionException(
            FeignException ex) {
        ErrorResponseDTO errorResponse =
                new ErrorResponseDTO(ex.getMessage(), String.valueOf(ex.status()), ex.request().url(), null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @Order
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleException(Exception ex) {
        // Manejo de excepción genérico
        ErrorResponseDTO errorResponse =
                new ErrorResponseDTO(ex.getMessage(), "500", ex.getMessage(), null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

}