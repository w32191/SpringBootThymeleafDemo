package com.samwang.springbootthymeleafdemo.service.impl;

import com.samwang.springbootthymeleafdemo.entity.MemberAccount;
import com.samwang.springbootthymeleafdemo.entity.Member;
import com.samwang.springbootthymeleafdemo.repository.MemberAccountRepository;
import com.samwang.springbootthymeleafdemo.service.MemberAccountService;
import com.samwang.springbootthymeleafdemo.service.MemberService;
import com.samwang.springbootthymeleafdemo.service.exception.AccountDuplicateException;
import com.samwang.springbootthymeleafdemo.service.exception.InsertException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberAccountServiceImpl implements MemberAccountService {

  @Autowired
  private MemberAccountRepository memberAccountRepository;

  @Autowired
  private MemberService memberService;

  @Transactional
  public String register(MemberAccount memberAccount, String name) {

    //檢查這個帳號是否有被註冊過
    MemberAccount data = memberAccountRepository.findByAccount(memberAccount.getAccount());
    if (data != null) {
      throw new AccountDuplicateException("此帳號已有註冊");
    }

    //新增帳號
    memberAccount.setCreateBy(memberAccount.getAccount());
    memberAccount.setUpdateBy(memberAccount.getAccount());
    MemberAccount result = memberAccountRepository.saveAndFlush(memberAccount);
    if (result == null) {
      throw new InsertException("新增時異常");
    }

    //寫入Ｍｅｍｂｅｒ資訊
    Member member = new Member();
    member.setMaID(result.getId());
    member.setName(name);
    member.setCreateBy(memberAccount.getAccount());
    member.setUpdateBy(memberAccount.getAccount());
    Member resultOfMember = memberService.add(member);
    if (resultOfMember == null) {
      throw new InsertException("新增時異常");
    }

    //正常註冊後 返回null
    return null;

  }

  @Override
  public Member login(MemberAccount memberAccount) {

    //檢查帳號是否存在
    MemberAccount data = memberAccountRepository.findByAccount(memberAccount.getAccount());
    if (data == null) {
      return null;
    }

    //核對密碼
    if (!data.getPassword()
        .equals(memberAccountRepository.getPassword(memberAccount.getPassword()))) {
      return null;
    }

    //取得會員資訊
    return memberService.getDataByMa_id(data.getId());
  }
}
