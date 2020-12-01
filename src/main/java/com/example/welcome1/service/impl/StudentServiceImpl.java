package com.example.welcome1.service.impl;

import com.example.welcome1.dao.StudentDao;
import com.example.welcome1.entity.Student;
import com.example.welcome1.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    @Override
    public Student findBySid(String sid) {
        return studentDao.findBySid(sid);
    }

    @Override
    public int setStudent(Student student) {
        return studentDao.setStudent(student);
    }
}
