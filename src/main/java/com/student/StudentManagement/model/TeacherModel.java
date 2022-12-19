package com.student.StudentManagement.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name= "Teacher")
public class TeacherModel {
    @Id
    private int id;
    private String name;
    private String sex;
}