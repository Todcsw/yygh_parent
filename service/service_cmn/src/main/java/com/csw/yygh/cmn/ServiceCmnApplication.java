package com.csw.yygh.cmn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/14 16:30 星期日
 * @Description: com.csw.yygh.cmn
 * @version: 1.0
 */

@SpringBootApplication
@ComponentScan(basePackages = {"com.csw"})
public class ServiceCmnApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceCmnApplication.class,args);
    }
}
