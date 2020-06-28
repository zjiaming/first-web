package com.zouwei.firstweb.service;

import com.zouwei.firstweb.model.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserService {

    int save(Map<String,String> userInfo);

    User findUserByPhone(@Param("phone") String phone);
}
