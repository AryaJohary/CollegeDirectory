package com.aryajohary.collegedirectory.dto;

public class StudentProfileDTO {
    private String username;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String photo;
    private String year;
    private Long departmentId;

    public StudentProfileDTO(){}

    public StudentProfileDTO(String username,
                             String password,
                             String role,
                             String name,
                             String email,
                             String phone,
                             String photo,
                             String year,
                             Long departmentId) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.photo = photo;
        this.year = year;
        this.departmentId = departmentId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
