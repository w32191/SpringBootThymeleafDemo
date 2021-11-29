package com.samwang.springbootthymeleafdemo.filter;

import com.samwang.springbootthymeleafdemo.entity.Member;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@WebFilter(filterName = "", urlPatterns = {"/*"})
@Order(value = 1)
public class LoginFilter implements Filter {


  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {

    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;

    //取得登入後，session中的member資料
    HttpSession session = request.getSession();
    Member member = (Member) session.getAttribute("MemberSession");

    String uri = request.getRequestURI();

    //放行全部靜態檔案路徑
    if (uri.contains("/css") || uri.contains("/images") || uri.contains("/js")) {
      filterChain.doFilter(servletRequest, servletResponse);
      return;
    }

    //已完成登入
    if (member != null) {
      if (uri.contains("/login") || uri.contains("/register")) {
        response.sendRedirect("/students");
      } else {
        filterChain.doFilter(servletRequest, servletResponse);
      }
    }
    //未登入
    else {
      if (uri.contains("/login") || uri.contains("/register")) {
        filterChain.doFilter(servletRequest, servletResponse);
      } else {
        response.sendRedirect("/login");
      }

    }

  }


}
