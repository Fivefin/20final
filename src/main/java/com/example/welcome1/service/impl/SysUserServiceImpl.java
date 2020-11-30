package com.example.welcome1.service.impl;


import com.example.welcome1.dao.SysUserDao;
import com.example.welcome1.entity.SysUser;
import com.example.welcome1.service.SysUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Date;

/**
 * (SysUser)表服务实现类
 *
 * @author makejava
 * @since 2020-11-26 20:55:19
 */
@Service
@Transactional
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserDao sysUserDao;

    @Override
    public void register(SysUser sysUser) {
        SysUser sysUserDB = sysUserDao.findByUName(sysUser.getUname());
        if(sysUserDB==null){
            sysUser.setState("1");
            sysUser.setLastLoginTime(new Date());
            sysUserDao.save(sysUser);
        }else{
            throw new RuntimeException("用户名已存在!");
        }


    }

    @Override
    public SysUser login(SysUser sysUser) {
        SysUser sysUserDB = sysUserDao.findByUName(sysUser.getUname());
        if(!ObjectUtils.isEmpty(sysUserDB)){
            if(sysUserDB.getUpwd().equals(sysUser.getUpwd())){
                return sysUserDB;
            }else{
                throw new RuntimeException("密码输入不正确！");
            }
        }else{
            throw new RuntimeException("用户名输入错误！");
        }
    }

    @Override
    public SysUser getInfo(SysUser sysUser) {
        SysUser sysUserDB = sysUserDao.findByUName(sysUser.getUname());
        return sysUserDB;
    }

    @Override
    public Integer updateInfo(SysUser sysUser) {
        SysUser sysUserByUname = sysUserDao.findByUName(sysUser.getUname());
        Integer updateDB = sysUserDao.updateSysUser(sysUserByUname);
        return updateDB;

    }

    @Override
    public Integer updatePwd(String uname) {
        SysUser sysUserByUname = sysUserDao.findByUName(uname);
        return sysUserDao.updatePwd(sysUserByUname);
    }

}