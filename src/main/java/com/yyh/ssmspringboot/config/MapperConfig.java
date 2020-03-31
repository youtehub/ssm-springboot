package com.yyh.ssmspringboot.config;

import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * MapperConfig
 *
 * @author zhangquanli
 */
@Configuration
@MapperScan(basePackages = "com.yyh.ssmspringboot.mybatis")
public class MapperConfig {
}
