package com.zouwei.firstweb.model.entity;


import org.springframework.web.client.RestTemplate;

public class Test {

    private void test(){
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.


    }


    /**
     * @Data : 注解在类上, 为类提供读写属性, 此外还提供了 equals()、hashCode()、toString() 方法 也提供了默认无参构造函数
     * @Getter/@Setter : 注解在类上, 为类提供读写属性
     * @ToString : 注解在类上, 为类提供 toString() 方法
     *
     * 要使用 @data 注解需要先添加插件  在添加依赖
     *
     * plugin {Lombok Plugin}
     *
     * <dependency>
     *             <groupId>org.projectlombok</groupId>
     *             <artifactId>lombok</artifactId>
     *             <version>1.16.10</version>
     *  </dependency>
     *
     *
     */


    /**
     * RestTemplate
     *
     * 	public static void testGetRequest(){
     *
     * 		RestTemplate restTemplate = new RestTemplate();
     * 		//2种方式获取
     * 		//1.直接获取响内容
     * //		String object = restTemplate.getForObject("http://localhost:8081/api/v1/pub/video/test",String.class);
     * //		System.out.println("object------->" +  object);
     *
     * //		//2.获取响应信息，包含响应状态、响应头、响应内容
     * 		ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:8081/api/v1/pub/video/test", String.class);
     * 		System.out.println(entity);
     * 		//响应状态码
     * 		System.out.println(entity.getStatusCode());
     * 		//响应头
     * 		System.out.println(entity.getHeaders());
     * 		//响应内容
     * 		System.out.println(entity.getBody());
     *        }
     *
     *
     */

}
