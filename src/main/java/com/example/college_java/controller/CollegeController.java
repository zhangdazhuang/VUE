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
    @RequestMapping("alltest") //访问路径
    public List<college> findAll(){
        return collegeMapper.findAll();
    }

    @RequestMapping("all")
    public List<college> findSchoolAll(int page){
        int pageCount = 20;
        return collegeMapper.findSchoolAll(page,pageCount);   //分页查询全部
    }
    @RequestMapping("alllen")
    public int findSchoolAllLen(){
        return collegeMapper.findSchoolAllLen();  //查询全部数据数量
    }

    @RequestMapping("province")
    public List<college> findSchoolByProvince(String province,int page){
        int pageCount = 20;
        return collegeMapper.findSchoolByProvince(province,page,pageCount);}  //按省份地区查询

    @RequestMapping("countProvince")
    public int countProvince(String province){
        return collegeMapper.countProvince(province);  //按省份查询的数量
    }

    @RequestMapping("bytype")
    public List<college> findbytype(String type,int page){
        int pageCount = 20;
        return collegeMapper.bytype(type,page,pageCount);}  //按类型查询

    @RequestMapping("countPlace")
    public int countType(String type){
        return collegeMapper.countType(type);  //按类型查询的数量
    }

    @RequestMapping("keyword")
    public List<college> findbykeyword(String keyword,int page){
        int pageCount = 20;
        return collegeMapper.findbykeyword(keyword,page,pageCount);}  //按关键字分页查询

    @RequestMapping("keywordlen")
    public int findbykeywordlen(String keyword){
        return collegeMapper.findbykeywordlen(keyword);}   //按关键字查询数量
}
