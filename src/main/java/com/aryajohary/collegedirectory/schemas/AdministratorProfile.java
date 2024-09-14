package com.aryajohary.collegedirectory.schemas;

import jakarta.persistence.*;

@Entity
@Table(name = "adminstratorprofile")
@PrimaryKeyJoinColumn(name = "user_id")
public class AdministratorProfile extends User{


    private String photo;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    public AdministratorProfile(){}

    public AdministratorProfile(String photo, Department department) {
        this.photo = photo;
        this.department = department;
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
}