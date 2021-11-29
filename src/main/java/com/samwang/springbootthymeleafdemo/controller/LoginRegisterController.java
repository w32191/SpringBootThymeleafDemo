package com.samwang.springbootthymeleafdemo.controller;


import com.samwang.springbootthymeleafdemo.entity.Member;
import com.samwang.springbootthymeleafdemo.entity.MemberAccount;
import com.samwang.springbootthymeleafdemo.service.MemberAccountService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LoginRegisterController {

  @Autowired
  private MemberAccountService memberAccountService;

  //get request 轉到login頁面
  @GetMapping("/login")
  public String login(@ModelAttribute MemberAccount memberAccount) {

    return "login";
  }

  //get request 轉到register頁面
  @GetMapping("/register")
  public String register(@ModelAttribute MemberAccount memberAccount) {
    return "register";
  }

  @PostMapping("/login")
  public String doLogin(
      @ModelAttribute MemberAccount memberAccount,
      Model model,
      HttpSession session) {

    Member result = memberAccountService.login(memberAccount);

    //沒找到會員資料，重新導至login
    if (result == null) {
      return "redirect:login";
    }

    //存放member result進session
    session.setAttribute("MemberSession", result);
    return "redirect:/students";
  }


  @PostMapping("/register")
  @ResponseBody
  public ResponseEntity<?> doRegister(@RequestParam(value = "name") String name,
      @RequestParam(value = "checkPassword") String checkPassword,
      @Validated @ModelAttribute MemberAccount memberAccount) {

    if (!memberAccount.getPassword().equals(checkPassword)) {
      return new ResponseEntity<>("兩次輸入密碼不相同", HttpStatus.OK);
    }

    String result = memberAccountService.register(memberAccount, name);

    return new ResponseEntity<>(result, HttpStatus.OK);
  }

}
