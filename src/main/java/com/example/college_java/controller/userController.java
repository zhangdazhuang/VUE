package com.example.college_java.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //设置方法返回值为字符串

@CrossOrigin //处理数据跨域

public class userController {
    @RequestMapping("/test")    //访问路径
    public String usertest(){
        return "This is usertest test";

    }
}
