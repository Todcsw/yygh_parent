package com.csw.yygh.hosp.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/12 16:52 星期五
 * @Description: com.csw.yygh.hosp.config
 * @version: 1.0
 */

@Configuration
@MapperScan("com.csw.yygh.hosp.mapper")
public class HospConfig {

    /**
     * 分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
