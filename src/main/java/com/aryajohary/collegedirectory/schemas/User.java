package com.aryajohary.collegedirectory.schemas;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "\"user\"")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    // id is generated automatically

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Must have a username")
    @Size(min = 6, max = 16, message = "Username length must be between 6 and 16")
    @Pattern(regexp = "^[a-zA-Z0-9._]{6,16}$", message = "Not a valid username")
    private String username;

    @NotNull(message = "Must have a password")
    @Size(min = 6, max = 16, message = "Password length must be between 8 and 16")
    private String password;

    @NotNull(message = "Role is required")
    @Enumerated(EnumType.STRING)
    private Role role;


    @NotNull(message = "Must have name")
    private String name;

    @NotNull(message = "Must have an email")
    private String email;

    private String phone;


    public User(){}

    public User(String username,
                String password,
                Role role,
                String name,
                String email,
                String phone) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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

}
