package com.student.StudentManagement.repo;

import com.student.StudentManagement.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<StudentModel,Integer> {

    @Query(value = "select * from Student  ",nativeQuery = true)
    List<StudentModel> ListStudentInfo();
    @Query(value = "select * from Student  where id=:Student_id ",nativeQuery = true)
    List<StudentModel> FindStudentInfo(@Param("Student_id")int Student_id);
    @Modifying
    @Transactional
    @Query(value = "delete from Student  where id=:Student_id ",nativeQuery = true)
    int deleteStudentByID(@Param("Student_id")int Student_id);
    @Transactional
    @Modifying
    @Query(value = "update Student set name=:name ,sex=:sex, maxscore=:maxscore, minscore=:minscore where id=:id ",nativeQuery = true)
    int updateStudentByID(@Param("name")String name,@Param("sex")String sex,@Param("maxscore")float maxscore,@Param("minscore")float minscore,@Param("id")int id);
    @Transactional
    @Modifying
    @Query(value = "insert into Student(name,sex,maxscore,minscore) values(:name,:sex,:maxscore,:minscore)",nativeQuery = true)
    int insertInformation(@Param("name")String name,@Param("sex")String sex,@Param("maxscore")float maxscore,@Param("minscore")float minscore);





}
