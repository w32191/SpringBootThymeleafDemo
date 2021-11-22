package com.samwang.springbootthymeleafdemo.repository;

import com.samwang.springbootthymeleafdemo.entity.MemberAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberAccountRepository extends JpaRepository<MemberAccount, Long> {

  MemberAccount findByAccount(String account);

  @Query(value = "SELECT PASSWORD FROM member_account WHERE ACCOUNT = ?", nativeQuery = true)
  String getPassword(String password);

}
