package com.emea.studentadmission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;
    @PostMapping(path="/student")
    public Student admission(@RequestBody Student studentReq){
        Student student = new Student();
        student =  studentService.admitStudent(studentReq);
        return student;
    }
}
