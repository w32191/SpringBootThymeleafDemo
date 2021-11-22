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
@Table(name = "member")
public class Member extends Base {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "MA_ID")
  private Long maID;

  @Column(name = "NAME")
  private String name;

  @Column(name = "BIRTHDAY")
  private String birthday;

  @Column(name = "PHONE")
  private String phone;

  @Column(name = "ADDRESS")
  private String address;

}
