package com.example.welcome1.service.impl;

import com.example.welcome1.dao.DromDao;
import com.example.welcome1.entity.Drom;
import com.example.welcome1.service.DromService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service
@Transactional
public class DromServiceImpl implements DromService {

    @Resource
    private DromDao dromDao;
    @Override
    public Drom findByDid(String did) {
        return dromDao.findByDid(did);
    }

    @Override
    public int updateDrom(Drom drom) {
        return dromDao.updateDrom(drom);
    }

    @Override
    public int addDrom(Drom drom) {
        return dromDao.addDrom(drom);
    }
}
