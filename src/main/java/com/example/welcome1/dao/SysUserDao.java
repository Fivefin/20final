package com.example.welcome1.dao;

import com.example.welcome1.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;


//@Mapper
public interface SysUserDao {
    //插入新用户
    void save(@Param("sysUser") SysUser sysUser);
    //根据角色查找
    List<SysUser> findByRole(String Rid);
    //根据权限查找
    List<SysUser> findByPerm(String Pid);
    //根据uid查找
    SysUser findByUid(String Uid);
    //根据用户名查找
    SysUser findByUName(String uname);
    //更新uanme、生日、邮箱、电话
    Integer updateSysUser(@Param("sysUser")SysUser sysUser);
    //更新密码
    Integer updatePwd(@Param("sysUser")SysUser sysUser);
    //
}