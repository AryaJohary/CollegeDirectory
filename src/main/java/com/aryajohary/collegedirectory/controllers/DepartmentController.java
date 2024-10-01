package com.aryajohary.collegedirectory.controllers;

import com.aryajohary.collegedirectory.schemas.Department;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @GetMapping("/syntax")
    public Department sendSyntax(){
        return new Department();
    }

}
