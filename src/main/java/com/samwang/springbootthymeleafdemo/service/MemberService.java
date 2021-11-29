package com.samwang.springbootthymeleafdemo.service;

import com.samwang.springbootthymeleafdemo.entity.Member;

public interface MemberService {


  Member add(Member member);
  Member getDataByMa_id(Long ma_id);
}
