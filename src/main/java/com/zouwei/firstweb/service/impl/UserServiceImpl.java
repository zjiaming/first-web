package com.zouwei.firstweb.service.impl;

import com.zouwei.firstweb.model.entity.User;
import com.zouwei.firstweb.mapper.UserMapper;
import com.zouwei.firstweb.service.UserService;
import com.zouwei.firstweb.utils.CommonUtils;
import com.zouwei.firstweb.utils.JWTUtils;
import io.jsonwebtoken.Jwts;
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
            int lows = userMapper.save(user);
            System.out.println("user--->id" + user.toString());
            return 1;
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

    @Override
    public String findByPhoneAndPwd(String phone, String pwd) {
        //注册的时候使用的是MD5加密的，所以这里也要加密
        User user = userMapper.findByPhoneAndPwd(phone, CommonUtils.MD5(pwd));
        if (user == null) {
            return null;
        }

        //登录成功返回 token 给前端
        String token = JWTUtils.geneJsonWebToken(user);


        return token;
    }

    @Override
    public int delete(String name) {
        return userMapper.delete(name);
    }

    @Override
    public int updateUserName(Map<String, Object> params) {
        if (params.containsKey("id") && params.containsKey("name")) {

            //数据库中的是integer,获取到的是string,所以在这里需要进行转换
            //Map<String,Object> params 前端上传的数据类型要正确，不能int类型上传一个String类型，要不然会报错
            Integer id = (Integer) params.get("id");
            return userMapper.updateUserName(id, (String) params.get("name"));
        }

        return -1;
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }
}
