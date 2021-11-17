package com.samwang.springbootthymeleafdemo.service;

import com.samwang.springbootthymeleafdemo.entity.Student;
import com.samwang.springbootthymeleafdemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

  @Autowired
  private StudentRepository studentRepository;

  @Override
  public Student findById(Integer studentId) {
    return studentRepository.findById(studentId).orElse(null);
  }

  @Override
  public Iterable<Student> creatStudent(Student student) {
    studentRepository.saveAndFlush(student);
    return getAllStudents();
  }

  @Override
  public Student editStudent(Integer studentId, Student student) {
    Student stu = studentRepository.findById(studentId).orElse(null);

    if (stu != null) {
      stu.setName(student.getName());
      stu.setEmailAddress(student.getEmailAddress());
      stu.setBirthday(student.getBirthday());
      studentRepository.saveAndFlush(stu);
      return stu;
    } else {
      return null;
    }
  }

  @Override
  public void deleteById(Integer studentId) {
    studentRepository.deleteById(studentId);
  }

  @Override
  public Iterable<Student> getAllStudents() {
    return studentRepository.findAll();
  }
}
