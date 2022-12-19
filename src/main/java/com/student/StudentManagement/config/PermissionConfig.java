package com.student.StudentManagement.config;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Data
@Configuration
public class PermissionConfig {

    private HashMap<String,String> permission = new HashMap<>();
    public PermissionConfig(){
        permission.put("admin","insert,update,delete,get,clearSession");
        permission.put("teacher","update,get");
        permission.put("student","get");
    }

}
