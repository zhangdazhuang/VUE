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
}
