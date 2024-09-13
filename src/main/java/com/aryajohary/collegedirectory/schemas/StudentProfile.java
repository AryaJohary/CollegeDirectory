package com.aryajohary.collegedirectory.schemas;

import jakarta.persistence.*;

@Entity
public class StudentProfile extends User {


    @Id
    @Column(name = "user_id")
    private Long user_id;

    private String photo;
    private String year;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    public StudentProfile(){}

    public StudentProfile(String photo, String year, Department department) {
        this.photo = photo;
        this.year = year;
        this.department = department;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
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