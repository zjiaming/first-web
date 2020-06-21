package com.zouwei.firstweb.mapper;

import com.zouwei.firstweb.domain.User;

public interface UserMapper {
    int save(User user);

    User findUserByPhone(String phone);
}
