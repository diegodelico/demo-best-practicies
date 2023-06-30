package com.example.demobestpracticies.exception;

import com.example.demobestpracticies.dto.ErrorResponseDTO;
import feign.FeignException;
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

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ErrorResponseDTO> handleValidationException(MethodArgumentNotValidException ex) {
//        BindingResult result = ex.getBindingResult();
//        ErrorResponseDTO errorResponse = new ErrorResponseDTO("Validation Error", "400", "", result.getFieldErrors());
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
//    }
//
//    @ExceptionHandler(DateTimeParseException.class)
//    public ResponseEntity<ErrorResponseDTO> handleDateTimeParseException(DateTimeParseException ex) {
//        ErrorResponseDTO errorResponse =
//                new ErrorResponseDTO("Validation Error", "400", ex.getMessage(), null);
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
//    }
//
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponseDTO> handleDateTimeParseException(ConstraintViolationException ex) {
        ErrorResponseDTO errorResponse =
                new ErrorResponseDTO("Validation Error", "400", ex.getMessage(), null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
//
    @ExceptionHandler(FeignException.FeignClientException.class)
    public ResponseEntity<ErrorResponseDTO> handleFeignClientExceptionException(
            FeignException ex) {
        ErrorResponseDTO errorResponse =
                new ErrorResponseDTO(ex.getMessage(), String.valueOf(ex.status()), ex.request().url(), null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

}