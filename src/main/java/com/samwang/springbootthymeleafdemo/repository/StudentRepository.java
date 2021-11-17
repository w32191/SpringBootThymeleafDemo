package com.samwang.springbootthymeleafdemo.repository;

import com.samwang.springbootthymeleafdemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

}
