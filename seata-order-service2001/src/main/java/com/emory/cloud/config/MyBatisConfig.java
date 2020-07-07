package com.emory.cloud.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.emory.cloud.dao"})
public class MyBatisConfig {

}
