package com.aryajohary.collegedirectory.controllers;

import com.aryajohary.collegedirectory.exception_handling.CustomEntityNotFoundException;
import com.aryajohary.collegedirectory.schemas.Department;
import com.aryajohary.collegedirectory.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    // this was made just so that I can have a look at
    // the syntax of User
    // so that I can know the structure to be put in
    // json format
    @GetMapping("/syntax")
    public Department sendSyntax(){
        return new Department();
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.save(department);
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.findAll();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id) {
        Department currDepartment = departmentService.findById(id);
        if(currDepartment == null){
            throw new CustomEntityNotFoundException("Department not found with id: "+id);
        }
        return currDepartment;
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentService.deleteById(id);
    }
}