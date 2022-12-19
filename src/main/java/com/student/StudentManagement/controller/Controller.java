package com.student.StudentManagement.controller;

//import com.student.StudentManagement.service.Management_service;
import com.student.StudentManagement.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

//import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@Component
@RequestMapping("StudentManagement/v1")
public class Controller {

    @Autowired
    private com.student.StudentManagement.service.ManagementService managementService;
    private final String correlationId =  UUID.randomUUID().toString();
    String errorMessage = " ";
    String errorCode = "200";
    HashMap<String,String>result = new HashMap<>();
    StudentManagementResponse studentManagementResponse = new StudentManagementResponse();

    @GetMapping("/clearSession/accounts/{username}")
    public ResponseEntity<StudentManagementResponse> ClearSession(@PathVariable("username")String username,@RequestHeader(value = "username",required = false) String user , @RequestHeader(value = "password",required = false) String password  ){
        result = checkUserAndPermission(user,password,"clearSession");
        if(result.get("errorMessage").equals("success")){
            managementService.clearSession(username);
            errorMessage = "success , clear session";
            studentManagementResponse = new StudentManagementResponse(correlationId,errorMessage,errorCode,errorMessage,new ArrayList<>());
        }
        else{
            errorMessage = result.get("errorMessage");
            errorCode = result.get("errorCode");
            studentManagementResponse = new StudentManagementResponse(correlationId,errorMessage,errorCode,errorMessage,new ArrayList<>());
        }
        return new ResponseEntity<StudentManagementResponse>(studentManagementResponse,HttpStatus.OK);
    }

    @GetMapping("getInformation/{destination}")
    public ResponseEntity<StudentManagementResponse> Display( @PathVariable("destination")String destination, @RequestHeader(value = "username",required = false) String user , @RequestHeader(value = "password",required = false) String password ){
        result = checkUserAndPermission(user,password,"get");
        if(result.get("errorMessage").equals("success")){
            List<StudentModel> studentModel = managementService.findInformation(destination);
            errorMessage = "success , transaction";
            studentManagementResponse = new StudentManagementResponse(correlationId,errorMessage,errorCode,errorMessage,studentModel);
        }
        else{
            errorMessage = result.get("errorMessage");
            errorCode = result.get("errorCode");
            studentManagementResponse = new StudentManagementResponse(correlationId,errorMessage,errorCode,errorMessage,new ArrayList<>());
        }
        return new ResponseEntity<StudentManagementResponse>(studentManagementResponse,HttpStatus.OK);
    }
    @GetMapping("getInformation/{destination}/{id}")
    public ResponseEntity<StudentManagementResponse> DisplayByID(@PathVariable("destination")String destination,@PathVariable("id")int id,@RequestHeader(value = "username",required = false) String user ,@RequestHeader(value = "password",required = false) String password ){
        result = checkUserAndPermission(user,password,"get");
        if(result.get("errorMessage").equals("success")){
            List<StudentModel> studentModel = managementService.findInformationByID(destination,id);
            studentManagementResponse = new StudentManagementResponse(correlationId,"success , transaction",errorCode,"success , get information", studentModel);
        }
        else {
            errorMessage = result.get("errorMessage");
            errorCode = result.get("errorCode");
            studentManagementResponse = new StudentManagementResponse(correlationId,errorMessage,errorCode,errorMessage,new ArrayList<>());
        }
        return new ResponseEntity<StudentManagementResponse>(studentManagementResponse,HttpStatus.OK);
    }
    @PostMapping("updateInformation/Student/{id}")
    public ResponseEntity<StudentManagementResponse> updateStudent(@RequestBody StudentModel studentModel,@PathVariable("id")int id,@RequestHeader(value = "username",required = false) String user ,@RequestHeader(value = "password",required = false) String password ){
        result = checkUserAndPermission(user,password,"update");
        if(result.get("errorMessage").equals("success")){
            List<StudentModel> studentManagementModel = new ArrayList<>();
            managementService.updateStudentInformation(studentModel,id);
            studentManagementResponse = new StudentManagementResponse(correlationId,"success , transaction",errorCode,"success , update information",studentManagementModel);
        }
        else{
            errorMessage = result.get("errorMessage");
            errorCode = result.get("errorCode");
            studentManagementResponse = new StudentManagementResponse(correlationId,errorMessage,errorCode,errorMessage,new ArrayList<>());
        }
        return new ResponseEntity<StudentManagementResponse>(studentManagementResponse,HttpStatus.OK);
    }
    @PostMapping("updateInformation/Teacher/{id}")
    public ResponseEntity<StudentManagementResponse> updateTeacher(@RequestBody TeacherModel teacherModel, @PathVariable("id")int id,@RequestHeader(value = "username",required = false) String user ,@RequestHeader(value = "password",required = false) String password ){
        result = checkUserAndPermission(user,password,"update");
        if(result.get("errorMessage").equals("success")){
            List<StudentModel> studentManagementModel = new ArrayList<>();
            managementService.updateTeacherInformation(teacherModel,id);
            studentManagementResponse = new StudentManagementResponse(correlationId,"success , transaction",errorCode,"success , update information",studentManagementModel);
        }
        else{
            errorMessage = result.get("errorMessage");
            errorCode = result.get("errorCode");
            studentManagementResponse = new StudentManagementResponse(correlationId,errorMessage,errorCode,errorMessage,new ArrayList<>());
        }
        return new ResponseEntity<StudentManagementResponse>(studentManagementResponse,HttpStatus.OK);
    }
    @PostMapping("updateInformation/Department/{id}")
    public ResponseEntity<StudentManagementResponse> updateDepartment(@RequestBody DepartmentModel departmentModel, @PathVariable("id")int id,@RequestHeader(value = "username",required = false) String user ,@RequestHeader(value = "password",required = false) String password ){
        result = checkUserAndPermission(user,password,"update");
        if(result.get("errorMessage").equals("success")){
            List<StudentModel> studentManagementModel = new ArrayList<>();
            managementService.updateDepartmentInformation(departmentModel,id);
            studentManagementResponse = new StudentManagementResponse(correlationId,"success , transaction",errorCode,"success , update information",studentManagementModel);
        }
        else{
            errorMessage = result.get("errorMessage");
            errorCode = result.get("errorCode");
            studentManagementResponse = new StudentManagementResponse(correlationId,errorMessage,errorCode,errorMessage,new ArrayList<>());
        }
        return new ResponseEntity<StudentManagementResponse>(studentManagementResponse,HttpStatus.OK);
    }
    @PostMapping("updateInformation/Subject/{id}")
    public ResponseEntity<StudentManagementResponse> updateSubject(@RequestBody SubjectModel subjectModel, @PathVariable("id")int id,@RequestHeader(value = "username",required = false) String user ,@RequestHeader(value = "password",required = false) String password ){
        result = checkUserAndPermission(user,password,"update");
        if(result.get("errorMessage").equals("success")){
            List<StudentModel> studentManagementModel = new ArrayList<>();
            managementService.updateSubjectInformation(subjectModel,id);
            studentManagementResponse = new StudentManagementResponse(correlationId,"success , transaction",errorCode,"success , update information",studentManagementModel);
        }
        else{
            errorMessage = result.get("errorMessage");
            errorCode = result.get("errorCode");
            studentManagementResponse = new StudentManagementResponse(correlationId,errorMessage,errorCode,errorMessage,new ArrayList<>());
        }
        return new ResponseEntity<StudentManagementResponse>(studentManagementResponse,HttpStatus.OK);
    }
    @PostMapping("insertInformation/Student")
    public ResponseEntity<StudentManagementResponse> InsertStudent(@RequestBody StudentModel studentModel,@RequestHeader(value = "username",required = false) String user ,@RequestHeader(value = "password",required = false) String password ){
        result = checkUserAndPermission(user,password,"insert");
        if(result.get("errorMessage").equals("success")){
            String resultDelete = managementService.insertStudentInformation(studentModel);
            if(resultDelete.equals("success")){
                errorCode = "0001";
                errorMessage="success,transaction";
            }
            else{
                errorCode = "0002";
                errorMessage="failed,transaction";
            }
            studentManagementResponse = new StudentManagementResponse(correlationId,errorMessage,errorCode,errorMessage,new ArrayList<>());
        }
        else{
            errorMessage = result.get("errorMessage");
            errorCode = result.get("errorCode");
            studentManagementResponse = new StudentManagementResponse(correlationId,errorMessage,errorCode,errorMessage,new ArrayList<>());
        }
        return new ResponseEntity<StudentManagementResponse>(studentManagementResponse,HttpStatus.OK);
    }
    @PostMapping("insertInformation/Teacher")
    public ResponseEntity<StudentManagementResponse> InsertTeacher(@RequestBody TeacherModel teacherModel,@RequestHeader(value = "username",required = false) String user ,@RequestHeader(value = "password",required = false) String password ){
        result = checkUserAndPermission(user,password,"insert");
        if(result.get("errorMessage").equals("success")){
            String resultDelete = managementService.insertTeacherInformation(teacherModel);
            if(resultDelete.equals("success")){
                errorCode = "0001";
                errorMessage="success,transaction";
            }
            else{
                errorCode = "0002";
                errorMessage="failed,transaction";
            }
            studentManagementResponse = new StudentManagementResponse(correlationId,errorMessage,errorCode,errorMessage,new ArrayList<>());
        }
        else{
            errorMessage = result.get("errorMessage");
            errorCode = result.get("errorCode");
            studentManagementResponse = new StudentManagementResponse(correlationId,errorMessage,errorCode,errorMessage,new ArrayList<>());
        }
        return new ResponseEntity<StudentManagementResponse>(studentManagementResponse,HttpStatus.OK);

    }
    @PostMapping("insertInformation/Department")
    public ResponseEntity<StudentManagementResponse> InsertDepartment(@RequestBody DepartmentModel departmentModel,@RequestHeader(value = "username",required = false) String user ,@RequestHeader(value = "password",required = false) String password ){
        result = checkUserAndPermission(user,password,"insert");
        if(result.get("errorMessage").equals("success")){
            String resultDelete = managementService.insertDepartmentInformation(departmentModel);
            if(resultDelete.equals("success")){
                errorCode = "0001";
                errorMessage="success,transaction";
            }
            else{
                errorCode = "0002";
                errorMessage="failed,transaction";
            }
            studentManagementResponse = new StudentManagementResponse(correlationId,errorMessage,errorCode,errorMessage,new ArrayList<>());
        }
        else{
            errorMessage = result.get("errorMessage");
            errorCode = result.get("errorCode");
            studentManagementResponse = new StudentManagementResponse(correlationId,errorMessage,errorCode,errorMessage,new ArrayList<>());
        }
        return new ResponseEntity<StudentManagementResponse>(studentManagementResponse,HttpStatus.OK);
    }
    @PostMapping("insertInformation/Subject")
    public ResponseEntity<StudentManagementResponse> InsertSubject(@RequestBody SubjectModel subjectModel,@RequestHeader(value = "username",required = false) String user ,@RequestHeader(value = "password",required = false) String password ){
        result = checkUserAndPermission(user,password,"insert");
        if(result.get("errorMessage").equals("success")){
            String resultDelete = managementService.insertSubjectInformation(subjectModel);
            if(resultDelete.equals("success")){
                errorCode = "0001";
                errorMessage="success,transaction";
            }
            else{
                errorCode = "0002";
                errorMessage="failed,transaction";
            }
            studentManagementResponse = new StudentManagementResponse(correlationId,errorMessage,errorCode,errorMessage,new ArrayList<>());
        }
        else{
            errorMessage = result.get("errorMessage");
            errorCode = result.get("errorCode");
            studentManagementResponse = new StudentManagementResponse(correlationId,errorMessage,errorCode,errorMessage,new ArrayList<>());
        }
        return new ResponseEntity<StudentManagementResponse>(studentManagementResponse,HttpStatus.OK);
    }

    @PostMapping("deleteInformation/{destination}/{id}")
    public ResponseEntity<StudentManagementResponse> DeleteByID(@PathVariable("destination")String destination,@PathVariable("id")int id,@RequestHeader(value = "username",required = false) String user ,@RequestHeader(value = "password",required = false) String password ){
        result = checkUserAndPermission(user,password,"delete");
        if(result.get("errorMessage").equals("success")){
            String resultDelete = managementService.deleteInformationByID(destination,id);
            if(resultDelete.equals("success")){
                errorCode = "0001";
                errorMessage="success,transaction";
            }
            else{
                errorCode = "0002";
                errorMessage="failed,transaction";
            }
            studentManagementResponse = new StudentManagementResponse(correlationId,errorMessage,errorCode,errorMessage,new ArrayList<>());
        }
        else{
            errorMessage = result.get("errorMessage");
            errorCode = result.get("errorCode");
            studentManagementResponse = new StudentManagementResponse(correlationId,errorMessage,errorCode,errorMessage,new ArrayList<>());
        }
        return new ResponseEntity<StudentManagementResponse>(studentManagementResponse,HttpStatus.OK);
    }

    public HashMap<String, String> checkUserAndPermission(String user, String password, String permission){
        String result = managementService.checkingUser(user,password,permission);
        HashMap<String,String>response = new HashMap<>();
        if(user==null && password==null){
            errorCode = "401";
            errorMessage = "Unauthorised , please check your username and password again !";
        }
        else if(result.equals("denied")){
            errorCode = "402";
            errorMessage = "Sorry , you don't have permission to do this !";
        }
        else if(result.equals("locked") ){
            errorCode = "423";
            errorMessage = "System detected you're try to login this account , please contact admin for assistant ";
        }
        else if(result.equals("fail")){
            errorCode = "417";
            errorMessage = "Incorrect Auth , please check your username and password again !";
        }
        else{
            errorMessage =  "success";
        }
        response.put("errorMessage",errorMessage);
        response.put("errorCode",errorCode);
        return response;
    }


}
