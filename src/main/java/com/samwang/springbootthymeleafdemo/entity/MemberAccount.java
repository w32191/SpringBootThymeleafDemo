package com.samwang.springbootthymeleafdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import javax.validation.constraints.NotBlank;
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

  @Email(message = "請以信箱格式做帳號")
  @NotBlank(message = "帳號不可為空")
  @Column(name = "ACCOUNT", unique = true)
  private String account;

  @NotBlank(message = "密碼不可為空")
  @Column(name = "PASSWORD")
  private String password;

  @Column(name = "SALT")
  private String salt;

}
