package com.emea.studentadmission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public Student admitStudent(Student studentReq){
        Student student = new Student();
        long num = studentRepo.count()+1;
        String admissionID = generateAdmissionNumber(num);
        studentReq.setId(admissionID);
        student = studentRepo.save(studentReq);
        return student;
    }

    private String generateAdmissionNumber(long num) {
        // admission number "R-001"
        String admissionNum = "R-"+num; // R-1
        int digits = (int) (Math.log10(num) + 1);
        if(digits == 1) {
            admissionNum = "R-"+"00"+num; //R-001
        }
        else if(digits == 2) {
            admissionNum = "R-"+"0"+num; //R-023
        }
        else {
            admissionNum = "R-"+num; //R-999
        }
        while(studentRepo.existsById(admissionNum)) {
            num = num +1;
            admissionNum = generateAdmissionNumber(num);
        }
        return admissionNum;
    }
    public List<Student> getAllStudents(){
        Student student1 = new Student();
        Student student2 = new Student();
        List<Student> students = new ArrayList<Student>();
        students = studentRepo.findAll();
        students = sortList(students);
        return students;
    }

    private List<Student> sortList(List<Student> students) {
        for(int i=0;i<students.size();i++){
            for(int j=i+1;j<students.size();j++){
                if(students.get(i).getName().compareTo(students.get(j).getName())>0){
                    Student temp = students.get(i);
                    students.set(i, students.get(j));
                    students.set(j, temp);
                }
            }
        }
        return students;
    }
}
