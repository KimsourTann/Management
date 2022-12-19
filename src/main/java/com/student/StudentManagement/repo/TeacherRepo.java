package com.student.StudentManagement.repo;

import com.student.StudentManagement.model.StudentModel;
import com.student.StudentManagement.model.TeacherModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface TeacherRepo extends JpaRepository<TeacherModel,Integer> {

    @Query(value = "select * from Teacher  ",nativeQuery = true)
    List<StudentModel> ListTeacherInfo();
    @Query(value = "select * from Teacher where id=:Teacher_id ",nativeQuery = true)
    List<StudentModel> FindTeacherInfo(@Param("Teacher_id")int Teacher_id);
    @Transactional
    @Modifying
    @Query(value = "delete from Teacher  where id=:id ",nativeQuery = true)
    int deleteTeacherByID(@Param("id")int id);
    @Transactional
    @Modifying
    @Query(value = "update Teacher set sex=:sex, name=:name,id=:id where id=:id ",nativeQuery = true)
    int updateDepartmentByID(@Param("name")String name,@Param("sex")String sex,@Param("id")int id);
    @Transactional
    @Modifying
    @Query(value = "insert into Teacher(name,sex) values(:name,:sex)",nativeQuery = true)
    int insertInformation(@Param("name")String name,@Param("sex")String sex);


}
