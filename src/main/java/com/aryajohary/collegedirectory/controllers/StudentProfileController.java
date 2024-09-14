package com.aryajohary.collegedirectory.controllers;

import com.aryajohary.collegedirectory.dto.StudentProfileDTO;
import com.aryajohary.collegedirectory.repos.DepartmentRepository;
import com.aryajohary.collegedirectory.schemas.Department;
import com.aryajohary.collegedirectory.schemas.Role;
import com.aryajohary.collegedirectory.schemas.StudentProfile;
import com.aryajohary.collegedirectory.services.DepartmentService;
import com.aryajohary.collegedirectory.services.StudentProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentProfiles")
public class StudentProfileController {
    @Autowired
    private StudentProfileService studentProfileService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/syntax")
    public StudentProfile sendSyntax(){
        return new StudentProfile("", "", Role.STUDENT, "", "", "", "", "", new Department());
    }

    @PostMapping
    public ResponseEntity<StudentProfile> createStudentProfile(@RequestBody StudentProfileDTO studentProfileDTO) {
        // Retrieve the Department entity by departmentId
        Department department = departmentService.findById(studentProfileDTO.getDepartmentId());

        if (department == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  // Handle if department is not found
        }

        // Create a new StudentProfile entity
        StudentProfile studentProfile = new StudentProfile();
        studentProfile.setUsername(studentProfileDTO.getUsername());
        studentProfile.setPassword(studentProfileDTO.getPassword());
        studentProfile.setRole(Role.STUDENT);
        studentProfile.setName(studentProfileDTO.getName());
        studentProfile.setEmail(studentProfileDTO.getEmail());
        studentProfile.setPhone(studentProfileDTO.getPhone());
        studentProfile.setPhoto(studentProfileDTO.getPhoto());
        studentProfile.setYear(studentProfileDTO.getYear());

        // Set the department
        studentProfile.setDepartment(department);

        // Save the student profile
        studentProfileService.save(studentProfile);

        return ResponseEntity.ok(studentProfile);
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