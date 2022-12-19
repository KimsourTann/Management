package com.student.StudentManagement.repo;

import com.student.StudentManagement.model.DepartmentModel;
import com.student.StudentManagement.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DepartmentRepo extends JpaRepository<DepartmentModel,Integer> {

    @Query(value = "select * from Department ",nativeQuery = true)
    List<StudentModel> ListDepartmentInfo();
    @Query(value = "select * from Department  where id=:Department_id ",nativeQuery = true)
    List<StudentModel> FindDepartmentInfo(@Param("Department_id")int Department_id);
    @Transactional
    @Modifying
    @Query(value = "delete from Department  where id=:id ",nativeQuery = true)
    int deleteDepartmentByID(@Param("id")int id);
    @Transactional
    @Modifying
    @Query(value = "update Department set name=:name,id=:id where id=:id ",nativeQuery = true)
    int updateDepartmentByID(@Param("name")String name,@Param("id")int id);
    @Transactional
    @Modifying
    @Query(value = "insert into Department(name) values(:name)",nativeQuery = true)
    int insertInformation(@Param("name")String name);


}
