package com.aryajohary.collegedirectory.services;

import com.aryajohary.collegedirectory.repos.CourseRepository;
import com.aryajohary.collegedirectory.schemas.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course save(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> saveAll(List<Course> courseList){
        return courseRepository.saveAll(courseList);
    }

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public Course findById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }

    public long size(){
        return courseRepository.count();
    }
}