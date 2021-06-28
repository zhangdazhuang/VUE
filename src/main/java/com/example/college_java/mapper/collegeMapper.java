package com.example.college_java.mapper;

import com.example.college_java.bean.college;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface collegeMapper {

    @Select("select * from collegesList")   //查询全部
    List<college> findAll();

//    @Select("select * from collegesList where type like \"%\" #{type} \"%\" limit #{page}, #{pageCount}")
    @Select("select * from collegesList limit #{page}, #{pageCount}")       //分页查询全部
    List<college> findSchoolAll(int page, int pageCount);

    @Select("select count(*) from collegeslist")        //查询全部数据数量
    int findSchoolAllLen();
// schoolname like "%" #{province} "%" or
//
    @Select("select * from collegesList where  province like \"%\" #{province} \"%\" limit #{page},#{pageCount} ")
    List<college> findSchoolByProvince(String province, int page, int pageCount);  //按省份地区查询

    @Select("select * from collegesList where  type like \"%\" #{type} \"%\" limit #{page},#{pageCount} ")
    List<college> bytype(String type, int page, int pageCount); //按类型查询

    @Select("select count(*) from collegesList where province like \"%\" #{province} \"%\" ")
    int countProvince(String province);   //按省份查询的数量

    @Select("SELECT count(*) FROM collegesList where type like \"%\" #{type} \"%\"")
    int countType(String type);   //按类型查询的数量

//    @Select("SELECT * from collegesList where schoolname like \"%\" #{keyword} \"%\" or province like \"%\" #{keyword} \"%\" limit #{page},#{pageCount}")
    @Select("select * from collegesList where  code like \"%\" #{keyword} \"%\" or schoolname like \"%\" #{keyword} \"%\" or  province like \"%\" #{keyword} \"%\" or city like \"%\" #{keyword} \"%\" or department like \"%\" #{keyword} \"%\" or level like \"%\" #{keyword} \"%\" or type like \"%\" #{keyword} \"%\" limit #{page},#{pageCount} ")
    List<college> findbykeyword(String keyword, int page, int pageCount);   //按关键字分页查询

//    @Select("SELECT count(*) from collegesList where schoolname like \"%\" #{keyword} \"%\" or province like \"%\" #{keyword} \"%\"")
    @Select("select count(*) from collegesList where  code like \"%\" #{keyword} \"%\" or schoolname like \"%\" #{keyword} \"%\" or  province like \"%\" #{keyword} \"%\" or city like \"%\" #{keyword} \"%\" or department like \"%\" #{keyword} \"%\" or level like \"%\" #{keyword} \"%\" or type like \"%\" #{keyword} \"%\" ")
    int findbykeywordlen(String keyword); //按关键字查询数量

}

