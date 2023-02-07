package com.emea.studentadmission;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Document(collection = "studentData")
public class Student {
    @Id
    private String id;

    @NotBlank
    @Size(min = 2, max = 50) @Pattern(regexp = "^[a-zA-Z\\s]+$")
    private String name;
    @NotNull
    @Past
    private LocalDate dob;
    @NotBlank
    private String studenClass;
    @NotBlank
    private String division;
    @NotBlank
    private String gender;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getStudenClass() {
        return studenClass;
    }

    public void setStudenClass(String studenClass) {
        this.studenClass = studenClass;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
