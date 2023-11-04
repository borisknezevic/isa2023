package com.bora.app.exception.controller;

import com.bora.app.exception.EmailAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({EmailAlreadyExistException.class})
    public ResponseEntity<ErrorObject> handleAlreadyExistException(RuntimeException runtimeException){
        ErrorObject response = ErrorObject.builder()
                .message(runtimeException.getMessage() +  " already exist!")
                .statusCode(409)
                .timeStamp(LocalDate.now())
                .build();
        return new ResponseEntity<>(response,HttpStatus.valueOf(409));
    }
}
