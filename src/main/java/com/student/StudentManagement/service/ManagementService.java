package com.student.StudentManagement.service;

import com.student.StudentManagement.config.PermissionConfig;
import com.student.StudentManagement.config.UserConfig;
import com.student.StudentManagement.model.DepartmentModel;
import com.student.StudentManagement.model.StudentModel;
import com.student.StudentManagement.model.SubjectModel;
import com.student.StudentManagement.model.TeacherModel;
import com.student.StudentManagement.repo.DepartmentRepo;
import com.student.StudentManagement.repo.StudentRepo;
import com.student.StudentManagement.repo.SubjectRepo;
import com.student.StudentManagement.repo.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ManagementService {

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private TeacherRepo teacherRepo;
    @Autowired
    private SubjectRepo subjectRepo;
    @Autowired
    private DepartmentRepo departmentRepo;
    @Autowired
    private UserConfig userConfig;
    @Autowired
    private PermissionConfig permissionConfig;
    @Autowired
    RedisTemplate<String,String> userCache;
    private final String success = "success";
    private final String fail = "fail";
    private final String locked = "locked";
    private final String denied = "denied";

    public List<StudentModel> findInformationByID(String destination, int id){
        if(destination.equals("Teacher")){
            return teacherRepo.FindTeacherInfo(id);
        }
        else if(destination.equals("Student")){
            return studentRepo.FindStudentInfo(id);
        }
        else if(destination.equals("Subject")){
            return subjectRepo.FindSubjectInfo(id);
        }
        else{
            return departmentRepo.FindDepartmentInfo(id);
        }
    }
    public List<StudentModel> findInformation(String destination){
        if(destination.equals("Teacher")){
            return teacherRepo.ListTeacherInfo();
        }
        else if(destination.equals("Student")){
            return studentRepo.ListStudentInfo();
        }
        else if(destination.equals("Subject")){
            return subjectRepo.ListSubjectInfo();
        }
        else{
            return departmentRepo.ListDepartmentInfo();
        }
    }
    public String deleteInformationByID(String destination,int id){
        int result = 0;
        if(destination.equals("Teacher")){
            result = teacherRepo.deleteTeacherByID(id);
            return result==1?success:fail;
        }
        else if(destination.equals("Student")){
            result = studentRepo.deleteStudentByID(id);
            return result==1?success:fail;
        }
        else if(destination.equals("Subject")){
            result =  subjectRepo.deleteSubjectByID(id);
            return result==1?success:fail;
        }
        else{
            result =  departmentRepo.deleteDepartmentByID(id);
            return result==1?success:fail;
        }
    }

    public String updateStudentInformation(StudentModel studentModel,int id){
        int result = 0;
        result = studentRepo.updateStudentByID(studentModel.getName(), studentModel.getSex(), studentModel.getMaxscore(), studentModel.getMinscore(),id);
        return result==1?success:fail;
    }
    public String updateDepartmentInformation(DepartmentModel departmentModel,int id){
        int result = 0;
        result = departmentRepo.updateDepartmentByID(departmentModel.getName(),id);
        return result==1?success:fail;
    }
    public String updateTeacherInformation(TeacherModel teacherModel,int id){
        int result = 0;
        result = teacherRepo.updateDepartmentByID(teacherModel.getName(),teacherModel.getSex(),id);
        return result==1?success:fail;
    }
    public String updateSubjectInformation(SubjectModel subjectModel,int id){
        int result = 0;
        result = subjectRepo.updateSubjectByID(subjectModel.getName(),id);
        return result==1?success:fail;
    }

    public String insertStudentInformation(StudentModel studentModel){
        int result = 0;
        result = studentRepo.insertInformation(studentModel.getName(), studentModel.getSex(), studentModel.getMaxscore(), studentModel.getMinscore());
        return result==1?success:fail;
    }
    public String insertDepartmentInformation(DepartmentModel departmentModel){
        int result = 0;
        result = departmentRepo.insertInformation(departmentModel.getName());
        return result==1?success:fail;
    }
    public String insertTeacherInformation(TeacherModel teacherModel){
        int result = 0;
        result = teacherRepo.insertInformation(teacherModel.getName(),teacherModel.getSex());
        return result==1?success:fail;
    }
    public String insertSubjectInformation(SubjectModel subjectModel){
        int result = 0;
        result = subjectRepo.insertInformation(subjectModel.getName());
        return result==1?success:fail;
    }

    public String checkingUser(String username,String password,String permission){
        String userInfo = userConfig.getUser().get(username);
        if(userCache.opsForHash().get(username,username)!=null && Objects.equals(userCache.opsForHash().get(username, username),"3")){
            return locked;
        }
        if(userInfo==null || !userInfo.equals(password)){
            if(userCache.opsForHash().get(username,username)==null){
                userCache.opsForHash().put(username,username,"1");
            }
            else{
                int count = Integer.parseInt(String.valueOf(userCache.opsForHash().get(username,username)));
                if(Objects.equals(userCache.opsForHash().get(username, username),3)){
                    return locked;
                }
                else {
                    int sum = count + 1;
                    userCache.opsForHash().put(username,username, String.valueOf(sum));
                }
            }
            return fail;
        }
        else{
            if(permissionConfig.getPermission().get(username).contains(permission))return success;
            else return denied;
        }
    }
    public void clearSession(String username){
        userCache.opsForHash().put(username,username,"0");
    }

}
