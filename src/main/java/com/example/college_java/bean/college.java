package com.example.college_java.bean;

import lombok.Data;

@Data  //编译的时候会自动生成getters and setters
public class college {
    int lineid;
    String code;
    String schoolname;
    String province;
    String city;
    String department;
    String level;
    String type;
    String link;

//    public void setLineid(int lineid) {
//        this.lineid = lineid;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public void setSchoolname(String schoolname) {
//        this.schoolname = schoolname;
//    }
//
//    public void setProvince(String province) {
//        this.province = province;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public void setDepartment(String department) {
//        this.department = department;
//    }
//
//    public void setLevel(String level) {
//        this.level = level;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public void setLink(String link) {
//        this.link = link;
//    }
//
//
//
//    public int getLineid() {
//        return lineid;
//    }
//
//    public String getCode() {
//        return code;
//    }
//
//    public String getSchoolname() {
//        return schoolname;
//    }
//
//    public String getProvince() {
//        return province;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public String getDepartment() {
//        return department;
//    }
//
//    public String getLevel() {
//        return level;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public String getLink() {
//        return link;
//    }


}
