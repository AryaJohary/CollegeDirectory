package com.aryajohary.collegedirectory.schemas;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "enrollment")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // many enrollments can belong to a single students
    // in other words, one student can have multiple courses, hence multiple enrollments
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private StudentProfile studentProfile;

    // multiple enrollments can belong to a single course
    // in other words, one course can have multiple enrollments
    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Course course;

    public Enrollment(){}

    public Enrollment(StudentProfile studentProfile, Course course) {
        this.studentProfile = studentProfile;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}