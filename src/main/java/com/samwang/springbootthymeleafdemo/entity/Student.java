package com.samwang.springbootthymeleafdemo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {


  @Id //primary key
  @GeneratedValue(strategy = GenerationType.IDENTITY)  //資料庫自動新增
  @Column(name = "id")
  Integer id;


  @Column(name = "name")
  String name;

  @Column(name = "email_address")
  String emailAddress;

  @Column(name = "birthday")
  java.sql.Date birthday;


  //取得save後id
  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public java.sql.Date getBirthday() {
    return birthday;
  }

  public void setBirthday(java.sql.Date birthday) {
    this.birthday = birthday;
  }
}
