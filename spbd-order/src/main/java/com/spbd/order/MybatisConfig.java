package com.spbd.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.spbd.order.mapper")
public class MybatisConfig {

}
