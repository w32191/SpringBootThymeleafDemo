package com.samwang.springbootthymeleafdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
//讓Base可以使用@EntityListeners(AuditingEntityListener.class)
// 監聽器，自動賦值創建時間、修改時間
@ServletComponentScan
//注意使用@WebServlet、@WebFilter、@WebListener 等Servlet 註釋時需要在Spring Boot 的啟動類別上添加@ServletComponentScan 註釋
public class SpringBootThymeleafDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootThymeleafDemoApplication.class, args);
  }

}
