package com.example.welcome1.entity;

import java.io.Serializable;

/**
 * (SysRolePermission)实体类
 *
 * @author makejava
 * @since 2020-11-26 20:55:01
 */
public class SysRolePermission implements Serializable {
    private static final long serialVersionUID = -12114651126943100L;
    /**
     * 角色id
     */
    private Integer rid;
    /**
     * 权限id
     */
    private Integer pid;


    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

}