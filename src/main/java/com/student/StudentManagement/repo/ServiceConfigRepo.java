package com.student.StudentManagement.repo;

import com.student.StudentManagement.model.ServiceConfigModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ServiceConfigRepo extends JpaRepository<ServiceConfigModel,Integer> {
    @Query(value = "SELECT  Skey as sKey,ShortName as shortName, LinkId as linkId FROM [CAMGSM-DWHS].[ProfillingDaily].[dbo].[DimReasonCode_SurePay] where ShortName =:clientName",nativeQuery = true)
    ServiceConfigModel find(@Param("clientName")String clientName);
}
