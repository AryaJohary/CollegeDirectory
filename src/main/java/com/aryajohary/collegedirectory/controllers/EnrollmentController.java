package com.aryajohary.collegedirectory.controllers;

import com.aryajohary.collegedirectory.exception_handling.CustomEntityNotFoundException;
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

    // this was made just so that I can have a look at
    // the syntax of User
    // so that I can know the structure to be put in
    // json format
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
        Enrollment currEnrollment = enrollmentService.findById(id);
        if(currEnrollment == null){
            throw new CustomEntityNotFoundException("Enrollment not found with Id: "+id);
        }
        return currEnrollment;
    }

    @DeleteMapping("/{id}")
    public void deleteEnrollment(@PathVariable Long id) {
        Enrollment currEnrollment = enrollmentService.findById(id);
        if(currEnrollment == null){
            throw new CustomEntityNotFoundException("Enrollment not found with Id: "+id);
        }
        enrollmentService.deleteById(id);
    }
}