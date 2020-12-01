package com.example.welcome1.service.impl;


import com.example.welcome1.dao.ClassDao;
import com.example.welcome1.entity.Class;
import com.example.welcome1.service.ClassService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class ClassServiceImpl implements ClassService {

    @Resource
    private ClassDao classDao;

    @Override
    public Class findByCid(String cid) {
        return classDao.findByCid(cid);
    }
}
