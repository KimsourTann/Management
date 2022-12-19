package com.student.StudentManagement.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Data {

    @JsonProperty
    String errorCode;
    @JsonProperty
    String errorMessage;
    @JsonProperty
    String description;
    @JsonProperty
    String correlationId;
    @JsonProperty
    List<StudentModel> data_information;

    public Data(String correlationId,String errorCode , String errorMessage , String description,List<StudentModel> studentModel){
        this.correlationId = correlationId;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.description = description;
        this.data_information = studentModel;
    }

}
