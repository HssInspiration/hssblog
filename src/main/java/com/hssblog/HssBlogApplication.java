package com.hssblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hssblog.mapper")
public class HssBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(HssBlogApplication.class, args);
    }

}
