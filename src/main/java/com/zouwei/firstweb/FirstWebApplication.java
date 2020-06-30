package com.zouwei.firstweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.zouwei.firstweb.mapper")
public class FirstWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstWebApplication.class, args);
	}


	/**
	 * 1.第一步要干嘛？ 先弄好项目配置  application.properties
	 * 2.先添加数据库中对应的实体类,在domain里面创建实体
	 * 3.创建对应的Mapper
	 *
	 * 数据共享的话使用分布式缓存，不需要的话使用本地缓存
	 *
	 */
}
