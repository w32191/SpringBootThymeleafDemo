package com.samwang.springbootthymeleafdemo.service.exception;

import org.hibernate.service.spi.ServiceException;

public class AccountDuplicateException extends RuntimeException {

  //帳號重複時的exception
  public AccountDuplicateException(String message) {
    super(message);
  }

}
