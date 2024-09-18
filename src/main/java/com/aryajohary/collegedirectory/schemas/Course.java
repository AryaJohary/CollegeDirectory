package com.aryajohary.collegedirectory.schemas;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Title can't be null")
    @Size(max = 100, message = "Title length must be less than 100")
    private String title;
    private String description;

    // many courses can belong to a single department

    @NotNull(message = "Department ID can't be null")
    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Department department;

    // many courses can belong to a single faculty
    // in other words, one faculty can teach multiple courses

    @NotNull(message = "Faculty ID can't be null")
    @ManyToOne
    @JoinColumn(name = "faculty_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private FacultyProfile facultyProfile;

    public Course(String title, String description, Department department, FacultyProfile facultyProfile) {
        this.title = title;
        this.description = description;
        this.department = department;
        this.facultyProfile = facultyProfile;
    }

    public Course(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public FacultyProfile getFacultyProfile() {
        return facultyProfile;
    }

    public void setFacultyProfile(FacultyProfile facultyProfile) {
        this.facultyProfile = facultyProfile;
    }
}