package com.example.welcome1.service;

import com.example.welcome1.entity.Student;

public interface StudentService {
    Student findBySid(String sid);

    int updateStu(Student student);

    int deleteStu(String sid);
}
