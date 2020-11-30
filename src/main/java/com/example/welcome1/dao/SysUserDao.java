package com.example.welcome1.dao;

import com.example.welcome1.entity.SysUser;
import org.apache.ibatis.annotations.Param;


//@Mapper
public interface SysUserDao {
    void save(@Param("sysUser") SysUser sysUser);

    SysUser findByUName(String uname);

}