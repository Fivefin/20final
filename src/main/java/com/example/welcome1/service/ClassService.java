package com.example.welcome1.service;

import com.example.welcome1.entity.Class;

import java.util.List;

public interface ClassService {
    Class findByCid(String cid);
    int addClass(Class _class);

    int deleteClass(String cid);

    int updateClass(Class _class);

    List<Class> findByCcollege(String ccollege);
}
