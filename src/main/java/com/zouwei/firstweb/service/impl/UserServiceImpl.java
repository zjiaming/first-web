package com.zouwei.firstweb.service.impl;

import com.zouwei.firstweb.domain.User;
import com.zouwei.firstweb.mapper.UserMapper;
import com.zouwei.firstweb.mapper.VideoMapper;
import com.zouwei.firstweb.service.UserService;
import com.zouwei.firstweb.utils.CommonUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 保存用户信息
     */
    @Override
    public int save(Map<String, String> userInfo) {
        User user = parseToUser(userInfo);
        if (user != null) {
            return userMapper.save(user);
        } else {
            return -1;
        }
    }

    private User parseToUser(Map<String, String> userInfo) {
        if (userInfo.containsKey("phone") && userInfo.containsKey("pwd") && userInfo.containsKey("name")) {
            User user = new User();
            user.setPhone(userInfo.get("phone"));
            // 密码要进行MD5加密
            String pwd = userInfo.get("pwd");
            user.setPwd(CommonUtils.MD5(pwd));

            user.setName(userInfo.get("name"));
            user.setHeadImg("");
            user.setCreateTime(new Date());
            return user;
        }
        return null;
    }

    /**
     * 通过手机号查询用户
     * 不要忘记了 param
     */
    @Override
    public User findUserByPhone(@Param("phone") String phone) {
        return userMapper.findUserByPhone(phone);
    }
}
