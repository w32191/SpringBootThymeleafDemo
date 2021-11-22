package com.samwang.springbootthymeleafdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
//讓Base可以使用@EntityListeners(AuditingEntityListener.class)
// 監聽器，自動賦值創建時間、修改時間
public class SpringBootThymeleafDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootThymeleafDemoApplication.class, args);
  }

}
