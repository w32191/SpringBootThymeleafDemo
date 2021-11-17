package com.samwang.springbootthymeleafdemo.controller;

import com.samwang.springbootthymeleafdemo.entity.Student;
import com.samwang.springbootthymeleafdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class StudentController {

  @Autowired
  private StudentService studentService;

  //取得全部學生資料
  @GetMapping("/students")
  public String getAllStudents(Model model) {
    Iterable<Student> studentsList = studentService.getAllStudents();
    Student emptyStudent = new Student();

    model.addAttribute("studentList", studentsList);
    model.addAttribute("studentObject", emptyStudent);

    return "studentlist";
  }

  //新增一名學生資料
  @PostMapping("/students")
  public String createStudent(@ModelAttribute Student student, Model model) {

    Iterable<Student> allStudentList = studentService.creatStudent(student);
    Student emptyStudent = new Student();

    model.addAttribute("studentList", allStudentList);
    model.addAttribute("studentObject", emptyStudent);

    return "redirect:/students";
  }

  //刪除學生資料
  @DeleteMapping("/student/{id}")
  public String deleteStudent(@PathVariable Integer id, Model model) {
    studentService.deleteById(id);
    Student emptyStudent = new Student();
    model.addAttribute("studentObject", emptyStudent);

    return "studentlist";
  }


  //修改現有學生資料
  @PostMapping("/student/edit/{id}")
  public String updateStudent(@PathVariable Integer id, @RequestBody Student student, Model model) {

    studentService.editStudent(id, student);
    Student emptyStudent = new Student();
    model.addAttribute("studentObject", emptyStudent);

    return "redirect:/students";
  }

  @PostMapping("/editform")
  public String editStudentForm(@ModelAttribute Student student, Model model) {
    Student editedStudent = studentService.editStudent(student.getId(), student);
    model.addAttribute("editedStudent", editedStudent);
    return "editform";
  }

}
