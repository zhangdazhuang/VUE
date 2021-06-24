package com.example.college_java;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
//@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@MapperScan("com.example.college_java.mapper")
public class CollegeJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CollegeJavaApplication.class, args);
    }

}
