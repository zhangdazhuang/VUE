package com.example.college_java.mapper;

import com.example.college_java.bean.college;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface collegeMapper {

    @Select("select * from collegesList")
    List<college> findAll();

//    @Select("select * from collegesList where type like \"%\" #{type} \"%\" limit #{page}, #{pageCount}")
    @Select("select * from collegesList  limit #{page}, #{pageCount}")
    List<college> findAllFromFirst(int page, int pageCount);

    @Select("select count(*) from collegeslist")
    int findAllFromFirstlen();
// schoolname like "%" #{province} "%" or
//
    @Select("select * from collegesList where  province like \"%\" #{province} \"%\" limit #{page},#{pageCount} ")
    List<college> findAllFromSecond(String province, int page, int pageCount);

    @Select("SELECT count(*) FROM collegesList where type like \"%\" #{type} \"%\"")
    int countPlace(String type);


    @Select("select count(*) from collegesList where code like \"%\" #{province} \"%\"  or schoolname like \"%\" #{province} \"%\" or province like \"%\" #{province} \"%\" or city like \"%\" #{province} \"%\" or department like \"%\" #{province} \"%\" or level like \"%\" #{province} \"%\" or type like \"%\" #{province} \"%\"")
    int countProvince(String province);

    @Select("select * from collegesList where  type like \"%\" #{type} \"%\" limit #{page},#{pageCount} ")
    List<college> bytype(String type, int page, int pageCount);

//    @Select("SELECT * from collegesList where schoolname like \"%\" #{keyword} \"%\" or province like \"%\" #{keyword} \"%\" limit #{page},#{pageCount}")
    @Select("select * from collegesList where  code like \"%\" #{keyword} \"%\" or schoolname like \"%\" #{keyword} \"%\" or  province like \"%\" #{keyword} \"%\" or city like \"%\" #{keyword} \"%\" or department like \"%\" #{keyword} \"%\" or level like \"%\" #{keyword} \"%\" or type like \"%\" #{keyword} \"%\" limit #{page},#{pageCount} ")
    List<college> findbykeyword(String keyword, int page, int pageCount);

//    @Select("SELECT count(*) from collegesList where schoolname like \"%\" #{keyword} \"%\" or province like \"%\" #{keyword} \"%\"")
    @Select("select count(*) from collegesList where  code like \"%\" #{keyword} \"%\" or schoolname like \"%\" #{keyword} \"%\" or  province like \"%\" #{keyword} \"%\" or city like \"%\" #{keyword} \"%\" or department like \"%\" #{keyword} \"%\" or level like \"%\" #{keyword} \"%\" or type like \"%\" #{keyword} \"%\" ")
    int findbykeywordlen(String keyword);

}

