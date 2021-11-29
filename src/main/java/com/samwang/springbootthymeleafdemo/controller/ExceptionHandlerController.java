package com.samwang.springbootthymeleafdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {
  @ExceptionHandler({RuntimeException.class})
  public ResponseEntity<?> handleServiceException(Throwable e) {

    return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
  }

}
