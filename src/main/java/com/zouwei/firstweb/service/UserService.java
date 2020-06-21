package com.zouwei.firstweb.service;

import com.zouwei.firstweb.domain.User;

import java.util.Map;

public interface UserService {

    int save(Map<String,String> userInfo);

    User findUserByPhone(String phone);
}
