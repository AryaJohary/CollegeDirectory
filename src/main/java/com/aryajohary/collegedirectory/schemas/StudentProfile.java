package com.aryajohary.collegedirectory.schemas;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "studentprofile")
@PrimaryKeyJoinColumn(name = "user_id")
@OnDelete(action = OnDeleteAction.CASCADE)
public class StudentProfile extends User {


    @Size(max = 50, message = "Photo url length should be under 255")
    private String photo;

    @Size(max = 50, message = "year value should be of maximum length 50")
    private String year;

    // many students can belong to single department

    @NotNull(message = "Must have a department ID")
    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
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