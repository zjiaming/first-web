package com.zouwei.firstweb.service;

import com.zouwei.firstweb.model.entity.User;

import java.util.Map;

public interface UserService {

    int save(Map<String, String> userInfo);

    User findUserByPhone(String phone);

    //这里不需要添加 params
    String findByPhoneAndPwd(String phone, String pwd);
}
