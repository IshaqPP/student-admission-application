package com.emea.studentadmission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @PostMapping(path="/student")
    public Student admission(@RequestBody Student studentReq){
        Student student = new Student();
        student =  studentService.admitStudent(studentReq);
        return student;
    }

    @GetMapping(path = "/allstudents")
    public List<Student> getAllStudents(){
        List<Student> students = new ArrayList<>();
        students = studentService.getAllStudents();
        return students;
    }
}
