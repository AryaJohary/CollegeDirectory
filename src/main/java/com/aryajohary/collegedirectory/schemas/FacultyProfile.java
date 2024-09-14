package com.aryajohary.collegedirectory.schemas;

import jakarta.persistence.*;

@Entity
@Table(name = "facultyprofile")
@PrimaryKeyJoinColumn(name = "user_id")
public class FacultyProfile extends User{


    private String photo;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    private String officeHours;

    public FacultyProfile(){}

    public FacultyProfile(String photo, Department department, String officeHours) {
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