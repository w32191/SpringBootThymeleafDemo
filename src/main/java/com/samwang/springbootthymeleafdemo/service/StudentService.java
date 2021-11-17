package com.samwang.springbootthymeleafdemo.service;

import com.samwang.springbootthymeleafdemo.entity.Student;


public interface StudentService {

  Student findById(Integer studentId);

  Student creatStudent(Student student);

  Student editStudent(Integer studentId, Student student);

  String deleteById(Integer studentId);

  Iterable<Student> findAll();
}
