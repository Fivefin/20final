package com.example.welcome1.service;


import com.example.welcome1.entity.SysUser;

import java.util.List;

public interface SysUserService {

    //用户注册
    void register(SysUser sysUser);
    //用户登录
    SysUser login(SysUser sysUser);
    //获取个人资料
    SysUser getInfo(SysUser sysUser);
    //冻结账户
    int closeByUid(String uid);
    //修改个人资料
    int updateInfo(SysUser sysUser);
    //修改密码
    int updatePwd(String uname);
    //根据角色查找用户
    List<SysUser> listByRole(String role);
}