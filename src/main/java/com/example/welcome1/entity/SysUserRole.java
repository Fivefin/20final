package com.example.welcome1.entity;

import java.io.Serializable;

/**
 * (SysUserRole)实体类
 *
 * @author makejava
 * @since 2020-11-26 20:55:32
 */
public class SysUserRole implements Serializable {
    private static final long serialVersionUID = 930801957910555051L;
    /**
     * 用户id
     */
    private Integer uid;
    /**
     * 角色id
     */
    private Integer rid;


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

}