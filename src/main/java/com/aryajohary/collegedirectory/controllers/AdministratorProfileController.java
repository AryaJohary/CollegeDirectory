package com.aryajohary.collegedirectory.controllers;

import com.aryajohary.collegedirectory.dto.AdministratorProfileDTO;
import com.aryajohary.collegedirectory.exception_handling.CustomEntityNotFoundException;
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
    public AdministratorProfile createAdministratorProfile(@RequestBody AdministratorProfileDTO administratorProfileDTO) {
        // get Department entity by departmentId
        Department department = departmentService.findById(administratorProfileDTO.getDepartmentId());

        if(department == null){
            throw new CustomEntityNotFoundException(
                    "Department not found with Id - "+administratorProfileDTO.getDepartmentId());
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
        return administratorProfileService.save(administratorProfile);

    }

    @PutMapping("/{id}")
    public AdministratorProfile updateAdministrator(@PathVariable Long id, @RequestBody AdministratorProfileDTO administratorProfileDTO){
        AdministratorProfile currAdministrator = administratorProfileService.findById(id);
        if(currAdministrator == null){
            throw new CustomEntityNotFoundException("Administrator Profile not found - "+id);
        }

        Department department = departmentService.findById(administratorProfileDTO.getDepartmentId());

        if(department == null){
            throw new CustomEntityNotFoundException(
                    "Department not found with Id - "+administratorProfileDTO.getDepartmentId());
        }

        currAdministrator.setDepartment(department);
        currAdministrator.setEmail(administratorProfileDTO.getEmail());
        currAdministrator.setName(administratorProfileDTO.getName());
        currAdministrator.setPassword(administratorProfileDTO.getPassword());
        currAdministrator.setPhone(administratorProfileDTO.getPhone());
        currAdministrator.setPhoto(administratorProfileDTO.getPhoto());
        currAdministrator.setUsername(administratorProfileDTO.getUsername());
        return administratorProfileService.save(currAdministrator);
    }

    @GetMapping
    public List<AdministratorProfile> getAllAdministratorProfiles() {
        return administratorProfileService.findAll();
    }

    @GetMapping("/{id}")
    public AdministratorProfile getAdministratorProfileById(@PathVariable Long id) {
        AdministratorProfile currAdmin = administratorProfileService.findById(id);
        if(currAdmin == null){
            throw new CustomEntityNotFoundException("Administrator Profile not found - "+id);
        }
        return currAdmin;
    }

    @DeleteMapping("/{id}")
    public void deleteAdministratorProfile(@PathVariable Long id) {
        AdministratorProfile currAdmin = administratorProfileService.findById(id);
        if(currAdmin == null){
            throw new CustomEntityNotFoundException("Administrator Profile not found - "+id);
        }
        administratorProfileService.deleteById(id);
    }
}