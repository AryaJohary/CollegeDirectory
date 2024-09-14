package com.aryajohary.collegedirectory.controllers;

import com.aryajohary.collegedirectory.dto.AdministratorProfileDTO;
import com.aryajohary.collegedirectory.schemas.AdministratorProfile;
import com.aryajohary.collegedirectory.schemas.Department;
import com.aryajohary.collegedirectory.schemas.AdministratorProfile;
import com.aryajohary.collegedirectory.schemas.Role;
import com.aryajohary.collegedirectory.services.AdministratorProfileService;
import com.aryajohary.collegedirectory.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administratorProfiles")
public class AdministratorProfileController {
    @Autowired
    private AdministratorProfileService administratorProfileService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/syntax")
    public AdministratorProfile sendSyntax(){
        return new AdministratorProfile("","", Role.ADMINISTRATOR,"","","","",new Department());
    }


    @PostMapping
    public ResponseEntity<AdministratorProfile> createAdministratorProfile(@RequestBody AdministratorProfileDTO administratorProfileDTO) {
        // Retrieve the Department entity by departmentId
        Department department = departmentService.findById(administratorProfileDTO.getDepartmentId());

        if (department == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  // Handle if department is not found
        }

        // Create a new administratorProfile entity
        AdministratorProfile administratorProfile = new AdministratorProfile();
        administratorProfile.setUsername(administratorProfileDTO.getUsername());
        administratorProfile.setPassword(administratorProfileDTO.getPassword());
        administratorProfile.setRole(Role.FACULTY_MEMBER);
        administratorProfile.setName(administratorProfileDTO.getName());
        administratorProfile.setEmail(administratorProfileDTO.getEmail());
        administratorProfile.setPhone(administratorProfileDTO.getPhone());
        administratorProfile.setPhoto(administratorProfileDTO.getPhoto());

        // Set the department
        administratorProfile.setDepartment(department);

        // Save the student profile
        administratorProfileService.save(administratorProfile);

        return ResponseEntity.ok(administratorProfile);
    }

    @GetMapping
    public List<AdministratorProfile> getAllAdministratorProfiles() {
        return administratorProfileService.findAll();
    }

    @GetMapping("/{id}")
    public AdministratorProfile getAdministratorProfileById(@PathVariable Long id) {
        return administratorProfileService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAdministratorProfile(@PathVariable Long id) {
        administratorProfileService.deleteById(id);
    }
}