package com.zouwei.firstweb.controller;

import com.zouwei.firstweb.model.request.LoginRequest;
import com.zouwei.firstweb.service.UserService;
import com.zouwei.firstweb.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/v1/pri/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     * 使用 requestBody 限制客户端端使用 json数据上传，不填写这个可以使用其他的格式上传数据
     *
     * @param userInfo
     * @return
     */
    @PostMapping("register")
    public JsonData register(@RequestBody Map<String, String> userInfo) {
        int rows = userService.save(userInfo);
        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("注册失败，请重试");
    }
    /**
     * 这里使用对象的方式，上面使用的是 map方式，两种方式都可以选择
     *
     * @param request
     * @return
     */
    @PostMapping("login")
    public JsonData login(@RequestBody LoginRequest request) {
        String token = userService.findByPhoneAndPwd(request.getPhone(), request.getPwd());

        return token == null ? JsonData.buildError("登录失败，账号密码错误") : JsonData.buildSuccess(token);
    }
}
