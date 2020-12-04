package com.example.welcome1.service.impl;


import com.example.welcome1.dao.ClassDao;
import com.example.welcome1.entity.Class;
import com.example.welcome1.service.ClassService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional

public class ClassServiceImpl implements ClassService {

    @Resource
    private ClassDao classDao;

    @Override
    public Class findByCid(String cid) {
        return classDao.findByCid(cid);
    }

    @Override
    public int addClass(Class _class) {
        return classDao.addClass(_class);
    }

    @Override
    public int deleteClass(String cid) {
        return classDao.deleteClass(cid);
    }

    @Override
    public int updateClass(Class _class) {
        return classDao.updateClass(_class);
    }

    @Override
    public List<Class> findByCcollege(String ccollege) {
        return classDao.findByCcollege(ccollege);
    }



}
