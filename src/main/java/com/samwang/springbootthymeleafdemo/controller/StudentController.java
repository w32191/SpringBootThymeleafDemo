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

  @GetMapping("/students")
  public String getAllStudents(Model model) {
    Iterable<Student> studentsList = studentService.getAllStudents();
    Student emptyStudent = new Student();

    model.addAttribute("studentList", studentsList);
    model.addAttribute("studentObject", emptyStudent);

    return "studentlist";
  }


  @PostMapping("/students")
  public String createStudent(@ModelAttribute Student student, Model model) {

    Iterable<Student> allStudentList = studentService.creatStudent(student);
    Student emptyStudent = new Student();

    model.addAttribute("studentList", allStudentList);
    model.addAttribute("studentObject", emptyStudent);

    return "studentlist";
  }

}
