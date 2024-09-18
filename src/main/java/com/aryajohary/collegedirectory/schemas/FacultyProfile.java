package com.aryajohary.collegedirectory.schemas;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "facultyprofile")
@PrimaryKeyJoinColumn(name = "user_id")
@OnDelete(action = OnDeleteAction.CASCADE)
public class FacultyProfile extends User{

    @Size(max = 50, message = "Photo url length should be under 255")
    private String photo;

    // many faculties can be in a single department
    @NotNull(message = "Department ID can't be null")
    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Department department;

    @Size(max = 255, message = "Office hours length must be less than 255")
    private String officeHours;

    public FacultyProfile(){}

    public FacultyProfile(String username,
                          String password,
                          Role role,
                          String name,
                          String email,
                          String phone,
                          String photo,
                          Department department,
                          String officeHours) {
        super(username, password, role, name, email, phone);
        this.photo = photo;
        this.department = department;
        this.officeHours = officeHours;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }
}