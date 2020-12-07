package com.example.welcome1.response;

public enum ResponseStatus {

    SUCCESS(200,"操作成功",true),
    LOGIN_SUCCESS(201,"登陆成功",true),
    LOGOUT_SUCCESS(202,"退出成功",true),
    JOIN_SUCCESS(203,"注册成功",true),
    FAILED(400,"操作失败",false),
    GET_RESOURCE_FAILED(401,"获取资源失败",false),
    ACCOUNT_NOT_LOGIN(402,"账号未登录",false),
    PERMISSION_DENIED(403,"无权操作",false),
    ACCOUNT_DENIED(404,"账号被禁止",false),
    ERROR_403(405,"权限不足",false),
    ERROR_404(406,"页面丢失",false),
    ERROR_504(407,"系统繁忙，请稍后重试",false),
    ERROR_505(408,"请求错误，请检查所提交数据",false),
    LOGIN_FAILED(500,"登录失败",false);

    ResponseStatus(int code, String message, boolean success) {
        this.code = code;
        this.message = message;
        this.success = success;
    }

    private int code;
    private String message;
    private boolean success;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
