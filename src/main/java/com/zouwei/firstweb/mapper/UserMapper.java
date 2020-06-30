package com.zouwei.firstweb.mapper;

import com.zouwei.firstweb.model.entity.User;
import com.zouwei.firstweb.model.entity.Video;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int save(User user);

    User findUserByPhone(@Param("phone") String phone);

    User findByPhoneAndPwd(@Param("phone") String phone, @Param("pwd") String pwd);

    //这里的name改成了names
    int delete(@Param("names") String name);

    //注意 数据库中的id是 Integer类型，所以这边的数据类型要和数据库中的数据类型对应上
    int updateUserName(@Param("id") Integer id, @Param("name") String name);

    int updateUser(User user);

}
