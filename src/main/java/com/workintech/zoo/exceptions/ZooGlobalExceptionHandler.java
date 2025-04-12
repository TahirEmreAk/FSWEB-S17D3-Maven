package com.workintech.zoo.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ZooGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity handleException(ZooException exception){
        ZooErrorResponse zooErrorResponse = new ZooErrorResponse(exception.getHttpStatus().value(), exception.getLocalizedMessage(), System.currentTimeMillis());
        log.error("Exception occured: ", exception);
        ResponseEntity responseEntity = new ResponseEntity<>(zooErrorResponse, exception.getHttpStatus());
        return responseEntity;
    }
}
