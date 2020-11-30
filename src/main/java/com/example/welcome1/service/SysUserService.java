package com.example.welcome1.service;


import com.example.welcome1.entity.SysUser;

public interface SysUserService {

    //用户祖注册
    void register(SysUser sysUser);
    //用户登录
    SysUser login(SysUser sysUser);

}