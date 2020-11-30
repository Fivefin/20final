package com.example.welcome1.entity;

import java.io.Serializable;

/**
 * (SysRole)实体类
 *
 * @author makejava
 * @since 2020-11-26 20:54:47
 */
public class SysRole implements Serializable {
    private static final long serialVersionUID = 972495590231384775L;
    /**
     * 角色id
     */
    private Integer rid;
    /**
     * 角色名
     */
    private String rname;
    /**
     * 角色状态
     */
    private String status;


    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}