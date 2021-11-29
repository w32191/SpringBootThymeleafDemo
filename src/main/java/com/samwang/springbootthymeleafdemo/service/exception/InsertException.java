package com.samwang.springbootthymeleafdemo.service.exception;

import org.hibernate.service.spi.ServiceException;

public class InsertException extends RuntimeException {

  public InsertException(String message) {
    super(message);
  }
}
