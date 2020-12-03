package com.example.welcome1.service;

import com.example.welcome1.entity.Class;

public interface ClassService {
    Class findByCid(String cid);
    int addClass(Class _class);

    int deleteClass(String cid);
}
