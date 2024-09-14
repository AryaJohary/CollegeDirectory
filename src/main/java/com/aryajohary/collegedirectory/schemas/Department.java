package com.aryajohary.collegedirectory.schemas;


import jakarta.persistence.*;

import java.util.Set;


@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

//    @OneToMany(mappedBy = "department")
//    private Set<StudentProfile> students;
//
//    @OneToMany(mappedBy = "department")
//    private Set<FacultyProfile> facultyMembers;
//
//    @OneToMany(mappedBy = "department")
//    private Set<AdministratorProfile> administrators;
//
//    @OneToMany(mappedBy = "department")
//    private Set<Course> courses;

    public Department(){}

    public Department(String name, String description) {
        this.name = name;
        this.description = description;
    }

    //    public Department(String name, String description,
//                      Set<StudentProfile> students,
//                      Set<FacultyProfile> facultyMembers,
//                      Set<AdministratorProfile> administrators,
//                      Set<Course> courses) {
//        this.name = name;
//        this.description = description;
//        this.students = students;
//        this.facultyMembers = facultyMembers;
//        this.administrators = administrators;
//        this.courses = courses;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
