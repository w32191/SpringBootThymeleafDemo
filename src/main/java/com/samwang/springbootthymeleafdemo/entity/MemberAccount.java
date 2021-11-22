package com.samwang.springbootthymeleafdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "member_account")
public class MemberAccount extends Base{


  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)  //資料庫自動新增
  private Long id;

  @Column(name = "ACCOUNT", unique = true)
  private String account;

  @Column(name = "PASSWORD")
  private String password;

  @Column(name = "SALT")
  private String salt;

}
