package com.example.college_java.controller;

import com.example.college_java.bean.college;
import com.example.college_java.mapper.collegeMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController //设置方法返回值为字符串
@RequestMapping("college") //访问路径
@CrossOrigin //处理数据跨域

public class CollegeController {
    @RequestMapping("/test")    //访问路径
    public String usertest(){
        return "This is collegetest test";
    }

    @Resource
    collegeMapper collegeMapper;
    @RequestMapping("all") //访问路径
    public List<college> findAll(){
        return collegeMapper.findAll();
    }

    @RequestMapping("first")
    public List<college> findAllFromFirstSchool(int page){
        int pageCount = 20;
        return collegeMapper.findAllFromFirst(page,pageCount);
    }
    @RequestMapping("firstlen")
    public int findAllFromFirstSchoollen(){
        return collegeMapper.findAllFromFirstlen();
    }

    @RequestMapping("second")
    public List<college> findAllFromSecond(String province,int page){
        int pageCount = 20;
        return collegeMapper.findAllFromSecond(province,page,pageCount);}

    @RequestMapping("countPlace")
    public int countPlace(String type){
        return collegeMapper.countPlace(type);
    }

    @RequestMapping("countProvince")
    public int countProvince(String province){
        return collegeMapper.countProvince(province);
    }

    @RequestMapping("bytype")
    public List<college> findbytype(String type,int page){
        int pageCount = 20;
        return collegeMapper.bytype(type,page,pageCount);}

    @RequestMapping("keyword")
    public List<college> findbykeyword(String keyword,int page){
        int pageCount = 20;
        return collegeMapper.findbykeyword(keyword,page,pageCount);}

    @RequestMapping("keywordlen")
    public int findbykeywordlen(String keyword){
        return collegeMapper.findbykeywordlen(keyword);}
}
