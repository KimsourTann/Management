package com.student.StudentManagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentManagementResponse {

    Data data;

    public StudentManagementResponse(String correlationId, String message, String status, String description, List<StudentModel> studentModel){
        this.data = new Data(correlationId,status,message,description, studentModel);
    }

}
