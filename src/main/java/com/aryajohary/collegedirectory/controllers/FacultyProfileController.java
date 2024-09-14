package com.aryajohary.collegedirectory.controllers;

import com.aryajohary.collegedirectory.dto.FacultyProfileDTO;
import com.aryajohary.collegedirectory.schemas.Department;
import com.aryajohary.collegedirectory.schemas.FacultyProfile;
import com.aryajohary.collegedirectory.schemas.Role;
import com.aryajohary.collegedirectory.schemas.StudentProfile;
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

    // this was made just so that I can have a look at
    // the syntax of User
    // so that I can know the structure to be put in
    // json format
    @GetMapping("/syntax")
    public FacultyProfileDTO sendSyntax(){
        return new FacultyProfileDTO();
    }

    // this helps in setting the proper StudentProfile object
    // by first creating a DTO, and then setting up the Roles and Department values
    // here in this controller
    @PostMapping
    public ResponseEntity<FacultyProfile> createFacultyProfile(@RequestBody FacultyProfileDTO facultyProfileDTO) {
        // get the Department entity by departmentId
        Department department = departmentService.findById(facultyProfileDTO.getDepartmentId());

        if (department == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  // Handle if department is not found
        }

        //  new facultyProfile entity
        FacultyProfile facultyProfile = new FacultyProfile();
        facultyProfile.setUsername(facultyProfileDTO.getUsername());
        facultyProfile.setPassword(facultyProfileDTO.getPassword());
        facultyProfile.setRole(Role.FACULTY_MEMBER);
        facultyProfile.setName(facultyProfileDTO.getName());
        facultyProfile.setEmail(facultyProfileDTO.getEmail());
        facultyProfile.setPhone(facultyProfileDTO.getPhone());
        facultyProfile.setPhoto(facultyProfileDTO.getPhoto());

        // set department
        facultyProfile.setDepartment(department);

        // save student profile
        facultyProfileService.save(facultyProfile);

        return ResponseEntity.ok(facultyProfile);
    }

    @PutMapping("/{id}")
    public FacultyProfile updateStudent(@PathVariable Long id, @RequestBody FacultyProfile facultyProfile){
        FacultyProfile currFaculty = facultyProfileService.findById(id);
        currFaculty.setDepartment(facultyProfile.getDepartment());
        currFaculty.setEmail(facultyProfile.getEmail());
        currFaculty.setName(facultyProfile.getName());
        currFaculty.setPassword(facultyProfile.getPassword());
        currFaculty.setPhone(facultyProfile.getPhone());
        currFaculty.setPhoto(facultyProfile.getPhoto());
        currFaculty.setUsername(facultyProfile.getUsername());
        currFaculty.setOfficeHours(facultyProfile.getOfficeHours());
        return facultyProfileService.save(currFaculty);
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

    // this is used to get a list of all students related to this faculty id
    @GetMapping("/listStudents/{id}")
    public List<StudentProfile> listStudents(@PathVariable Long id){
        return facultyProfileService.listStudents(id);
    }

}