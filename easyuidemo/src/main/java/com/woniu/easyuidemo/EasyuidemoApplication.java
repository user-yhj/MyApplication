package com.woniu.easyuidemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value="com.woniu.easyuidemo.dao")
public class EasyuidemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyuidemoApplication.class, args);
    }

}
