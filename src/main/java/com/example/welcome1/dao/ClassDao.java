package com.example.welcome1.dao;

import com.example.welcome1.entity.Class;


public interface ClassDao {
    //根据cid查找班级所有信息
    Class findByCid(String cid);

    int addClass(Class _class);

    int deleteClass(String cid);
}
