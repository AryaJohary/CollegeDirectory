package com.aryajohary.collegedirectory.schemas;

import jakarta.persistence.*;

@Entity
@Table(name = "studentprofile")
@PrimaryKeyJoinColumn(name = "user_id")
public class StudentProfile extends User {


    private String photo;
    private String year;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    public StudentProfile(){}


    public StudentProfile(String username,
                          String password,
                          Role role,
                          String name,
                          String email,
                          String phone,
                          String photo,
                          String year,
                          Department department) {
        super(username, password, role, name, email, phone);
        this.photo = photo;
        this.year = year;
        this.department = department;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}