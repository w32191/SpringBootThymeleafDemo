package com.samwang.springbootthymeleafdemo.service;

import com.samwang.springbootthymeleafdemo.entity.Student;
import com.samwang.springbootthymeleafdemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceimpl implements StudentService {

  @Autowired
  private StudentRepository studentRepository;

  @Override
  public Student findById(Integer studentId) {
    return studentRepository.findById(studentId).orElse(null);
  }

  @Override
  public Iterable<Student> findAll() {
    return studentRepository.findAll();

  }

  @Override
  public Student creatStudent(Student student) {
    studentRepository.saveAndFlush(student);

    return student;
  }

  @Override
  public Student editStudent(Integer studentId, Student student) {
    Student stu = studentRepository.findById(studentId).orElse(null);

    if (stu != null) {
      stu.setName(student.getName());
      stu.setBirthday(student.getBirthday());
      stu.setEmailAddress(student.getEmailAddress());
      return studentRepository.save(stu);

    } else {
      return null;
    }
  }

  @Override
  public String deleteById(Integer studentId) {
    Student student = studentRepository.findById(studentId).orElse(null);
    studentRepository.deleteById(studentId);

    return "已完成刪除";
  }


}
