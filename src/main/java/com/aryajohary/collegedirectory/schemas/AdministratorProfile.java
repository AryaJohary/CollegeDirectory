package com.aryajohary.collegedirectory.schemas;

import jakarta.persistence.*;

@Entity
public class AdministratorProfile extends User{
    @Id
    @Column(name = "user_id")
    private Long id;

    private String photo;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    public AdministratorProfile(){}

    public AdministratorProfile(String photo, Department department) {
        this.photo = photo;
        this.department = department;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
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