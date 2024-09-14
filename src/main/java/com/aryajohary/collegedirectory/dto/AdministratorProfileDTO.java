package com.aryajohary.collegedirectory.dto;

/***
 * I have used this DTO because to create a
 * AdministratorProfile, we need a Department object to be
 * put in the department field.
 * We can't pass that object directly from the
 * form, so, instead I am getting the department Id
 * and then fetching the department object using that Id
 * so that I can put it in the table as a proper
 * AdministratorProfile object
 *
 * This part where i fetch and set up the department
 * takes place in the controller file
 * ***/


public class AdministratorProfileDTO {
    private String username;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String photo;
    private Long departmentId;

    public AdministratorProfileDTO(){}


    public AdministratorProfileDTO(String username,
                                   String password,
                                   String name,
                                   String email,
                                   String phone,
                                   String photo,
                                   Long departmentId) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.photo = photo;
        this.departmentId = departmentId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartment_id(Long departmentId) {
        this.departmentId = departmentId;
    }
}
