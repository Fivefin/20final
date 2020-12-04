package com.example.welcome1.dao;

import com.example.welcome1.entity.Student;

public interface StudentDao {
    //按sid查找学生
    Student findBySid(String sid);
    //更新学生所有信息
    int updateStu(Student student);
    //删除学生信息
    int deleteStu(String sid);
}
