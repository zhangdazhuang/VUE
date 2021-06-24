package com.example.college_java.controller;

import com.example.college_java.bean.user;
import com.example.college_java.mapper.userMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController //设置方法返回值为字符串
@RequestMapping("user") //访问路径
@CrossOrigin //处理数据跨域

public class userController {
    @RequestMapping("/test")    //访问路径
    public String usertest(){
        return "This is usertest test";
    }

    @Resource
    userMapper userMapper;
    @RequestMapping("all") //访问路径
    public List<user> findAll(){
        return userMapper.findAll();
    }
}
