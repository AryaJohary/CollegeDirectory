package com.aryajohary.collegedirectory.controllers;

import com.aryajohary.collegedirectory.schemas.FacultyProfile;
import com.aryajohary.collegedirectory.services.FacultyProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facultyProfiles")
public class FacultyProfileController {
    @Autowired
    private FacultyProfileService facultyProfileService;

    @PostMapping
    public FacultyProfile createFacultyProfile(@RequestBody FacultyProfile facultyProfile) {
        return facultyProfileService.save(facultyProfile);
    }

    @GetMapping
    public List<FacultyProfile> getAllFacultyProfiles() {
        return facultyProfileService.findAll();
    }

    @GetMapping("/{id}")
    public FacultyProfile getFacultyProfileById(@PathVariable Long id) {
        return facultyProfileService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteFacultyProfile(@PathVariable Long id) {
        facultyProfileService.deleteById(id);
    }
}