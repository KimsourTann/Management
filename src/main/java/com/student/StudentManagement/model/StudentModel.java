package com.student.StudentManagement.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name= "Student")
public class StudentModel {
    @Id
    private int id;
    private String name;
    private String sex;
    private float maxscore;
    private float minscore;
}
