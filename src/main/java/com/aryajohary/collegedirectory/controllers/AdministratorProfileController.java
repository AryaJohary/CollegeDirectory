package com.aryajohary.collegedirectory.controllers;

import com.aryajohary.collegedirectory.dto.AdministratorProfileDTO;
import com.aryajohary.collegedirectory.schemas.AdministratorProfile;
import com.aryajohary.collegedirectory.schemas.Department;
import com.aryajohary.collegedirectory.schemas.Role;
import com.aryajohary.collegedirectory.schemas.StudentProfile;
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

    // this was made just so that I can have a look at
    // the syntax of User
    // so that I can know the structure to be put in
    // json format
    @GetMapping("/syntax")
    public AdministratorProfileDTO sendSyntax(){
        return new AdministratorProfileDTO();
    }

    // this helps in setting the proper StudentProfile object
    // by first creating a DTO, and then setting up the Roles and Department values
    // here in this controller
    @PostMapping
    public ResponseEntity<AdministratorProfile> createAdministratorProfile(@RequestBody AdministratorProfileDTO administratorProfileDTO) {
        // get Department entity by departmentId
        Department department = departmentService.findById(administratorProfileDTO.getDepartmentId());

        if (department == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  // Handle if department is not found
        }

        //  new administratorProfile entity
        AdministratorProfile administratorProfile = new AdministratorProfile();
        administratorProfile.setUsername(administratorProfileDTO.getUsername());
        administratorProfile.setPassword(administratorProfileDTO.getPassword());
        administratorProfile.setRole(Role.ADMINISTRATOR);
        administratorProfile.setName(administratorProfileDTO.getName());
        administratorProfile.setEmail(administratorProfileDTO.getEmail());
        administratorProfile.setPhone(administratorProfileDTO.getPhone());
        administratorProfile.setPhoto(administratorProfileDTO.getPhoto());

        // set department
        administratorProfile.setDepartment(department);

        // save student profile
        administratorProfileService.save(administratorProfile);

        return ResponseEntity.ok(administratorProfile);
    }

    @PutMapping("/{id}")
    public AdministratorProfile updateStudent(@PathVariable Long id, @RequestBody StudentProfile administratorProfile){
        AdministratorProfile currAdministrator = administratorProfileService.findById(id);
        currAdministrator.setDepartment(administratorProfile.getDepartment());
        currAdministrator.setEmail(administratorProfile.getEmail());
        currAdministrator.setName(administratorProfile.getName());
        currAdministrator.setPassword(administratorProfile.getPassword());
        currAdministrator.setPhone(administratorProfile.getPhone());
        currAdministrator.setPhoto(administratorProfile.getPhoto());
        currAdministrator.setUsername(administratorProfile.getUsername());
        return administratorProfileService.save(currAdministrator);
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