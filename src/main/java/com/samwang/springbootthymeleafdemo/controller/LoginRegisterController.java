package com.samwang.springbootthymeleafdemo.controller;


import com.samwang.springbootthymeleafdemo.entity.MemberAccount;
import com.samwang.springbootthymeleafdemo.service.MemberAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
  public String doLogin(@ModelAttribute MemberAccount memberAccount, Model model) {

    Boolean result = memberAccountService.login(memberAccount);
    if (result) {
      return "redirect:/students";
    } else {
      return "login";
    }

  }


  @PostMapping("/register")
  @ResponseBody
  public String doRegister(@RequestParam(value = "name") String name,
      @RequestParam(value = "checkPassword") String checkPassword,
      @ModelAttribute MemberAccount memberAccount) {

    if (!memberAccount.getPassword().equals(checkPassword)) {
      return "兩次輸入密碼不相同";
    }

    String result = memberAccountService.register(memberAccount, name);
    if (result != null) {
      return result;
    } else {
      return "註冊成功";
    }


  }

}
