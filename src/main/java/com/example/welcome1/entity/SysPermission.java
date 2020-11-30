package com.example.welcome1.entity;

import java.io.Serializable;

/**
 * (SysPermission)实体类
 *
 * @author makejava
 * @since 2020-11-26 20:53:52
 */
public class SysPermission implements Serializable {
    private static final long serialVersionUID = -26918838687643114L;
    /**
     * 权限id
     */
    private Integer pid;
    /**
     * 权限
     */
    private String permission;
    /**
     * 权限描述
     */
    private String description;
    /**
     * url
     */
    private String url;


    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}