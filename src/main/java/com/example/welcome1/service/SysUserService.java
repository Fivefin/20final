package com.example.welcome1.service;


import com.example.welcome1.entity.SysUser;

public interface SysUserService {

    //用户注册
    void register(SysUser sysUser);
    //用户登录
    SysUser login(SysUser sysUser);
    //获取个人资料
    SysUser getInfo(SysUser sysUser);
    //修改个人资料
    Integer updateInfo(SysUser sysUser);
    //修改密码
    Integer updatePwd(String uname);
}