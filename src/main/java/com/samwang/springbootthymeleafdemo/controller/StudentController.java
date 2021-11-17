package com.samwang.springbootthymeleafdemo.controller;

import com.samwang.springbootthymeleafdemo.entity.Student;
import com.samwang.springbootthymeleafdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

  @Autowired
  private StudentService studentService;

  //回選單
  @GetMapping("/mainmenu")
  public String menu() {
    return "mainmenu";
  }

  //新增畫面,將一個空的Student Object 用model傳給view
  @GetMapping("/addform")
  public String addForm(Model model) {
    Student student = new Student();
    model.addAttribute("student", student);
    return "addform";
  }
  //
  @PostMapping("/add")
  public String add(@ModelAttribute Student student, Model model) {
    Student result = studentService.creatStudent(student);
    model.addAttribute("studentresult", result);
    return "add";
  }

  @GetMapping("/showallform")
  public String showAllStudent(Model model) {
    Iterable<Student> studentList = studentService.findAll();
    model.addAttribute("studentlist", studentList);
    return "showallform";
  }

}
