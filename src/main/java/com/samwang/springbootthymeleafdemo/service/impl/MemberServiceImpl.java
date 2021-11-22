package com.samwang.springbootthymeleafdemo.service.impl;

import com.samwang.springbootthymeleafdemo.entity.Member;
import com.samwang.springbootthymeleafdemo.repository.MemberRepository;
import com.samwang.springbootthymeleafdemo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

  @Autowired
  private MemberRepository memberRepository;

  @Override
  public Member add(Member member) {

    return memberRepository.save(member);
  }

  @Override
  public Member getDataByMa_id(String ma_id) {
    return memberRepository.findByMaID(ma_id);
  }
}
