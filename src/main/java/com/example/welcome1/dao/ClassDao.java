package com.example.welcome1.dao;

import com.example.welcome1.entity.Class;

import java.util.List;


public interface ClassDao {
    //添加班级
    int addClass(Class _class);
    //删除班级
    int deleteClass(String cid);
    //修改班级
    int updateClass(Class _class);
    //获取所有班级
    List<Class> findAll();
    //根据cid查找班级所有信息
    Class findByCid(String cid);
    //根据学院查看班级
    List<Class> findByCcollege(String ccollege);
}
