package com.zouwei.firstweb.model.request;

/**
 * 登录
 */
public class LoginRequest {

    private String pwd;

    private String phone;

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
