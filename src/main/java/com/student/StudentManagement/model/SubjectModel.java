package com.student.StudentManagement.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name= "Subject")
public class SubjectModel {
    @Id
    private int id;
    private String name;
}