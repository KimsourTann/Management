package com.student.StudentManagement.config;

import lombok.Data;
import org.apache.catalina.User;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Data
@Configuration
public class UserConfig {

    private HashMap<String,String> user = new HashMap<>();
    public UserConfig(){
        user.put("admin","12345");
        user.put("teacher","12345");
        user.put("student","12345");
    }


}
