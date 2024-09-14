package com.aryajohary.collegedirectory.controllers;

import com.aryajohary.collegedirectory.dto.StudentProfileDTO;
import com.aryajohary.collegedirectory.schemas.Department;
import com.aryajohary.collegedirectory.schemas.FacultyProfile;
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

    // this was made just so that I can have a look at
    // the syntax of User
    // so that I can know the structure to be put in
    // json format
    @GetMapping("/syntax")
    public StudentProfileDTO sendSyntax(){
        return new StudentProfileDTO();
    }

    // this helps in setting the proper StudentProfile object
    // by first creating a DTO, and then setting up the Roles and Department values
    // here in this controller
    @PostMapping
    public ResponseEntity<StudentProfile> createStudentProfile(@RequestBody StudentProfileDTO studentProfileDTO) {
        // get the Department entity by departmentId
        Department department = departmentService.findById(studentProfileDTO.getDepartmentId());

        if (department == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  // Handle if department is not found
        }

        //  new StudentProfile entity
        StudentProfile studentProfile = new StudentProfile();
        studentProfile.setUsername(studentProfileDTO.getUsername());
        studentProfile.setPassword(studentProfileDTO.getPassword());
        studentProfile.setRole(Role.STUDENT);
        studentProfile.setName(studentProfileDTO.getName());
        studentProfile.setEmail(studentProfileDTO.getEmail());
        studentProfile.setPhone(studentProfileDTO.getPhone());
        studentProfile.setPhoto(studentProfileDTO.getPhoto());
        studentProfile.setYear(studentProfileDTO.getYear());

        // set department
        studentProfile.setDepartment(department);

        // save student profile
        studentProfileService.save(studentProfile);

        return ResponseEntity.ok(studentProfile);
    }

    @PutMapping("/{id}")
    public StudentProfile updateStudent(@PathVariable Long id, @RequestBody StudentProfile studentProfile){
        StudentProfile currStudent = studentProfileService.findById(id);
        currStudent.setDepartment(studentProfile.getDepartment());
        currStudent.setEmail(studentProfile.getEmail());
        currStudent.setName(studentProfile.getName());
        currStudent.setPassword(studentProfile.getPassword());
        currStudent.setPhone(studentProfile.getPhone());
        currStudent.setPhoto(studentProfile.getPhoto());
        currStudent.setUsername(studentProfile.getUsername());
        currStudent.setYear(studentProfile.getYear());
        return studentProfileService.save(currStudent);
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

    // this is used to get a list of all faculties related to this student id
    @GetMapping("/listFaculty/{id}")
    public List<FacultyProfile> getFacultyList(@PathVariable Long id){
        return studentProfileService.findFacultyForStudent(id);
    }
}