package com.aryajohary.collegedirectory.dto;

/***
 * I have used this DTO because to create a
 * FacultyProfile, we need a Department object to be
 * put in the department field.
 * We can't pass that object directly from the
 * form, so, instead I am getting the department Id
 * and then fetching the department object using that Id
 * so that I can put it in the table as a proper
 * FacultyProfile object
 *
 * This part where i fetch and set up the department
 * takes place in the controller file
 * ***/

public class FacultyProfileDTO {
    private String username;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String photo;
    private String officeHours;
    private Long departmentId;

    public FacultyProfileDTO(){}

    public FacultyProfileDTO(String username,
                             String password,
                             String name,
                             String email,
                             String phone,
                             String photo,
                             String officeHours,
                             Long departmentId) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.photo = photo;
        this.officeHours = officeHours;
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

    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
