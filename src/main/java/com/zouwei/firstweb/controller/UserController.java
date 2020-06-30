package com.zouwei.firstweb.controller;

import com.zouwei.firstweb.model.entity.User;
import com.zouwei.firstweb.model.request.LoginRequest;
import com.zouwei.firstweb.service.UserService;
import com.zouwei.firstweb.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 写这个接口想到的问题：
     * 1.userController 中的方法名字是否需要和 userMapper一样呢? 不需要
     * 2.get方法和post方法参数传入的问题 {@RequestBody 只有 post方法才能使用}
     * 3，{RequestBody} 在一个方法中只能使用一个
     * 根据用户名删除指定的用户
     * <p>
     * 注意：
     * UserMapper 中的 @Param("names") String name 参数对应的是 UserMapper.xml  #{names} 中的字段
     * 使用 @RequestBody 注解需要使用 map或者 对象的形式，
     */
    @GetMapping("delete_user")
    public JsonData deleteUser(@RequestParam(value = "name", required = true) String name) {
        int rows = userService.delete(name);
        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("删除用户失败");
    }

    /**
     * 通过 id 修改用户名
     */
    @PostMapping("update_name")
    public JsonData updateUserName(@RequestBody Map<String, String> params) {
        int rows = userService.updateUserName(params);
        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("更新用户名字失败");
    }

    /**
     * 通过 id 修改用户名
     */
    @PostMapping("update_user")
    public JsonData updateUser(@RequestBody User user) {
        int rows = userService.updateUser(user);
        return rows == 1 ? JsonData.buildSuccess("更新用户数据成功") : JsonData.buildError("更新用户数据失败");
    }
}
