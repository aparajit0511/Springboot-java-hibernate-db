package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.transaction.Transactional;

import java.util.List;

public interface StudentDAO {

    // implement save method
    @Transactional
    void save(Student theStudent);

    Student findById(Integer Id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student theStudent);
}