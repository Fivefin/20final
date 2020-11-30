package com.example.welcome1.dao;

import com.example.welcome1.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;


//@Mapper
public interface SysUserDao {
    //插入新用户
    int save(@Param("sysUser") SysUser sysUser);
    //冻结用户
    int closeByUid(@Param("uid")String uid);
    //更新uanme、生日、邮箱、电话
    int updateSysUser(@Param("sysUser")SysUser sysUser);
    //更新密码
    int updatePwd(@Param("sysUser")SysUser sysUser);
    //根据uid查找
    SysUser findByUid(@Param("uid")String uid);
    //根据用户名查找
    SysUser findByUName(@Param("uname")String uname);
    //根据角色查找
    List<SysUser> listByRole(@Param("role")String role);


}