package com.samwang.springbootthymeleafdemo.service;

import com.samwang.springbootthymeleafdemo.entity.MemberAccount;

public interface MemberAccountService {

  // 邏輯處理
  String register(MemberAccount memberAccount, String name);

  Boolean login(MemberAccount memberAccount);
}
