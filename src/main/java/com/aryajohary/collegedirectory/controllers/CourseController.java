package com.aryajohary.collegedirectory.controllers;

import com.aryajohary.collegedirectory.exception_handling.CustomEntityNotFoundException;
import com.aryajohary.collegedirectory.schemas.Course;
import com.aryajohary.collegedirectory.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    // this was made just so that I can have a look at
    // the syntax of User
    // so that I can know the structure to be put in
    // json format
    @GetMapping("/syntax")
    public Course sendSyntax(){
        return new Course();
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.save(course);
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.findAll();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        Course currCourse = courseService.findById(id);
        if(currCourse == null){
            throw new CustomEntityNotFoundException("Course not found with Id: "+id);
        }
        return currCourse;
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        Course currCourse = courseService.findById(id);
        if(currCourse == null){
            throw new CustomEntityNotFoundException("Course not found with Id: "+id);
        }
        courseService.deleteById(id);
    }
}