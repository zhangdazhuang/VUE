package com.example.college_java.mapper;

import com.example.college_java.bean.college;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface collegeMapper {

    @Select("select * from collegesList")
    List<college> findAll();

//    @Select("select * from collegesList where type like \"%\" #{type} \"%\" limit #{page}, #{pageCount}")
    @Select("select * from collegesList  limit #{page}, #{pageCount}")
    List<college> findAllFromFirst(String type, int page, int pageCount);

    @Select("select * from collegesList")
    List<college> findAllFromFirstlen(String type, int page, int pageCount);

    @Select("select * from collegesList where  code like \"%\" #{province} \"%\" or schoolname like \"%\" #{province} \"%\" or  province like \"%\" #{province} \"%\" or city like \"%\" #{province} \"%\" or department like \"%\" #{province} \"%\" or level like \"%\" #{province} \"%\" or type like \"%\" #{province} \"%\" limit #{page},#{pageCount} ")

//    @Select("select * from collegesList where schoolname like \"%\" #{province} \"%\" or province like \"%\" #{province} \"%\" limit #{page},#{pageCount} ")
    List<college> findAllFromSecond(String province, int page, int pageCount);

    @Select("SELECT count(*) FROM collegesList where type like \"%\" #{type} \"%\"")
    int countPlace(String type);

//    @Select("SELECT count(*) from collegesList where schoolname like \"%\" #{province} \"%\" or province like \"%\" #{province} \"%\"")
    @Select("select count(*) from collegesList where code like \"%\" #{province} \"%\"  or schoolname like \"%\" #{province} \"%\" or province like \"%\" #{province} \"%\" or city like \"%\" #{province} \"%\" or department like \"%\" #{province} \"%\" or level like \"%\" #{province} \"%\" or type like \"%\" #{province} \"%\"")
    int countProvince(String province);

}

