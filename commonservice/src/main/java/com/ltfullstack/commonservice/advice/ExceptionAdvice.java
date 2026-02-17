package com.ltfullstack.commonservice.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ltfullstack.commonservice.model.ErrorMessage;

@ControllerAdvice
public class ExceptionAdvice {
    
    @ExceptionHandler
    public ResponseEntity<ErrorMessage> handleException(Exception ex) {
        return new ResponseEntity(new ErrorMessage("9999", ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
