package com.csw.yygh.hosp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/12 16:27 星期五
 * @Description: com.csw.yygh.hosp
 * @version: 1.0
 */

@SpringBootApplication
@ComponentScan(basePackages = "com.csw")
public class ServiceHospApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceHospApplication.class,args);
    }
}
