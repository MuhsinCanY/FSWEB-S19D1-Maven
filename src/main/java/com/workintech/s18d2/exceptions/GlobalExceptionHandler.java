package com.workintech.s18d2.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    ResponseEntity<ErrorResponse> handleException(PlantException plantException) {

        log.error("Plant exception occured!!!");
        ErrorResponse errorResponse =
                new ErrorResponse(plantException.getMessage());

        return new ResponseEntity<>(errorResponse, plantException.getHttpStatus());
    }

    @ExceptionHandler
    ResponseEntity<ErrorResponse> handleException(Exception exception) {

        log.error("Global exception occured!!!");
        ErrorResponse errorResponse =
                new ErrorResponse(exception.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
