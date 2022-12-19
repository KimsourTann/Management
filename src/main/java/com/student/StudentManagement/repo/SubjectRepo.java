package com.student.StudentManagement.repo;

import com.student.StudentManagement.model.StudentModel;
import com.student.StudentManagement.model.SubjectModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SubjectRepo extends JpaRepository<SubjectModel,Integer> {

    @Query(value = "select * from Subject  ",nativeQuery = true)
    List<StudentModel> ListSubjectInfo();
    @Query(value = "select * from Subject  where id=:Subject_id ",nativeQuery = true)
    List<StudentModel> FindSubjectInfo(@Param("Subject_id")int Subject_id);
    @Modifying
    @Transactional
    @Query(value = "delete from Subject  where id=:id ",nativeQuery = true)
    int deleteSubjectByID(@Param("id")int id);
    @Transactional
    @Modifying
    @Query(value = "update Subject set name=:name,id=:id where id=:id ",nativeQuery = true)
    int updateSubjectByID(@Param("name")String name,@Param("id")int id);
    @Transactional
    @Modifying
    @Query(value = "insert into Subject(name) values(:name)",nativeQuery = true)
    int insertInformation(@Param("name")String name);



}
