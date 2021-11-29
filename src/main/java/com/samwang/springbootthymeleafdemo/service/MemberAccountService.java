package com.samwang.springbootthymeleafdemo.service;

import com.samwang.springbootthymeleafdemo.entity.Member;
import com.samwang.springbootthymeleafdemo.entity.MemberAccount;

public interface MemberAccountService {

  // 邏輯處理
  String register(MemberAccount memberAccount, String name);

  Member login(MemberAccount memberAccount);
}
