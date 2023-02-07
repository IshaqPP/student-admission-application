package com.emea.studentadmission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
