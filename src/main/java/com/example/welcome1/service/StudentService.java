package com.example.welcome1.service;

import com.example.welcome1.entity.Student;

public interface StudentService {
    Student findBySid(String sid);

    int setStudent(Student student);
}
