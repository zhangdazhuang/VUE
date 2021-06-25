package com.example.college_java.mapper;

import com.example.college_java.bean.college;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface collegeMapper {

    @Select("select * from collegesList")
    List<college> findAll();

    @Select("select * from collegesList where type like \"%\" #{type} \"%\" limit #{page}, #{pageCount}")
    List<college> findAllFromFirst(String type, int page, int pageCount);

    @Select("select * from collegesList where province like \"%\" #{province} \"%\" limit #{page},#{pageCount} ")
    List<college> findAllFromSecond(String province, int page, int pageCount);

    @Select("SELECT count(*) FROM collegesList where type like \"%\" #{type} \"%\"")
    int countPlace(String type);

    @Select("SELECT count(*) FROM collegesList where province like \"%\" #{province} \"%\"")
    int countProvince(String province);

}

