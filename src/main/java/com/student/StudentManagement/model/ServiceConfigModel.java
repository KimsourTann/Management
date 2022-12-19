package com.student.StudentManagement.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "[DimReasonCode_SurePay]")
public class ServiceConfigModel {
    @Id
    private int sKey;
    private String shortName;
    private String linkId;

    public ServiceConfigModel(String[] dateCache){
        this.sKey = Integer.parseInt(dateCache[0].replace("skey:",""));
        this.shortName =   dateCache[1].replace("shortname:","");
        this.linkId =   dateCache[2].replace("linkid:","");
    }


}
