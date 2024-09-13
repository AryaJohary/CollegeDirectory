package com.aryajohary.collegedirectory.controllers;

import com.aryajohary.collegedirectory.schemas.StudentProfile;
import com.aryajohary.collegedirectory.services.StudentProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentProfiles")
public class StudentProfileController {
    @Autowired
    private StudentProfileService studentProfileService;

    @PostMapping
    public StudentProfile createStudentProfile(@RequestBody StudentProfile studentProfile) {
        return studentProfileService.save(studentProfile);
    }

    @GetMapping
    public List<StudentProfile> getAllStudentProfiles() {
        return studentProfileService.findAll();
    }

    @GetMapping("/{id}")
    public StudentProfile getStudentProfileById(@PathVariable Long id) {
        return studentProfileService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentProfile(@PathVariable Long id) {
        studentProfileService.deleteById(id);
    }
}