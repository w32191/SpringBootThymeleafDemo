package com.samwang.springbootthymeleafdemo.service;

import com.samwang.springbootthymeleafdemo.entity.Student;


public interface StudentService {

  Student findById(Integer studentId);

  Iterable<Student> creatStudent(Student student);

  Student editStudent(Integer studentId, Student student);

  void deleteById(Integer studentId);

  Iterable<Student> getAllStudents();
}
