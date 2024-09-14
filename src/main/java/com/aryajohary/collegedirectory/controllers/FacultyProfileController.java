package com.aryajohary.collegedirectory.controllers;

import com.aryajohary.collegedirectory.dto.FacultyProfileDTO;
import com.aryajohary.collegedirectory.schemas.Department;
import com.aryajohary.collegedirectory.schemas.FacultyProfile;
import com.aryajohary.collegedirectory.schemas.Role;
import com.aryajohary.collegedirectory.services.DepartmentService;
import com.aryajohary.collegedirectory.services.FacultyProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facultyProfiles")
public class FacultyProfileController {
    @Autowired
    private FacultyProfileService facultyProfileService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/syntax")
    public FacultyProfile sendSyntax(){
        return new FacultyProfile("","",Role.FACULTY_MEMBER, "","", "", "", new Department(), "");
    }


    @PostMapping
    public ResponseEntity<FacultyProfile> createFacultyProfile(@RequestBody FacultyProfileDTO facultyProfileDTO) {
        // Retrieve the Department entity by departmentId
        Department department = departmentService.findById(facultyProfileDTO.getDepartmentId());

        if (department == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  // Handle if department is not found
        }

        // Create a new facultyProfile entity
        FacultyProfile facultyProfile = new FacultyProfile();
        facultyProfile.setUsername(facultyProfileDTO.getUsername());
        facultyProfile.setPassword(facultyProfileDTO.getPassword());
        facultyProfile.setRole(Role.FACULTY_MEMBER);
        facultyProfile.setName(facultyProfileDTO.getName());
        facultyProfile.setEmail(facultyProfileDTO.getEmail());
        facultyProfile.setPhone(facultyProfileDTO.getPhone());
        facultyProfile.setPhoto(facultyProfileDTO.getPhoto());

        // Set the department
        facultyProfile.setDepartment(department);

        // Save the student profile
        facultyProfileService.save(facultyProfile);

        return ResponseEntity.ok(facultyProfile);
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