package com.samwang.springbootthymeleafdemo.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@ToString
@MappedSuperclass //宣告為實體類的父類別，它並不是完整的實體類，所以不會映射到資料表，但它的屬性會映射到它的子類別資料表中，可用於設定相同欄位。
@EntityListeners(AuditingEntityListener.class) //監聽器，自動賦值創建時間、修改時間
public class Base {


  @CreatedBy  //設定為建立者，當實體被INSERT 時會預設值
  @Column(name = "CREATE_BY")
  private String createBy;


  @CreatedDate  // 設定為建立時間，當實體被INSERT時會預設值
  @Temporal(TemporalType.TIMESTAMP) //宣告該Column 儲存到資料表時的時間精度(TIMESTAMP:日期和時間)
  @Column(name = "CREATE_TIME")
  private Date creatTime;


  @LastModifiedBy //設定為修改者，當實體被UPDATE時會預設值
  @Column(name = "UPDATE_BY")
  private String updateBy;

  @LastModifiedDate //設定為修改時間，當實體被UPDATE時會預設值
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "UPDATE_TIME")
  private Date update_time;


}
