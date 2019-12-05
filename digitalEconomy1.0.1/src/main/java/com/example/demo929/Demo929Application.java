package com.example.demo929;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

/*
2019.9.7
lmw
实现功能：根据前端url请求（请求方式为get），从mysql数据库，redis中取数据并以json格式返回
应用场景：乌镇项目-智慧经济页面，6个小图的数据
待优化：数据库获取数据之后对json数据的处理方式上代码有冗余，可以采用json属性过滤方式，待优化
 */
@EnableEurekaClient
@RestController
@SpringBootApplication
@MapperScan("com.example.demo929.mapper")
public class Demo929Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo929Application.class, args);
    }

}
