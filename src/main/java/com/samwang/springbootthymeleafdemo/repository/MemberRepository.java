package com.samwang.springbootthymeleafdemo.repository;

import com.samwang.springbootthymeleafdemo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

  Member findByMaID(Long ma_id);

}
