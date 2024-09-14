package com.aryajohary.collegedirectory.controllers;

import com.aryajohary.collegedirectory.schemas.Enrollment;
import com.aryajohary.collegedirectory.services.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping("/syntax")
    public Enrollment sendSyntax(){
        return new Enrollment();
    }

    @PostMapping
    public Enrollment createEnrollment(@RequestBody Enrollment enrollment) {
        return enrollmentService.save(enrollment);
    }

    @GetMapping
    public List<Enrollment> getAllEnrollments() {
        return enrollmentService.findAll();
    }

    @GetMapping("/{id}")
    public Enrollment getEnrollmentById(@PathVariable Long id) {
        return enrollmentService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEnrollment(@PathVariable Long id) {
        enrollmentService.deleteById(id);
    }
}