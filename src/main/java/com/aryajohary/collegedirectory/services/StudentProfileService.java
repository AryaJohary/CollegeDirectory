package com.aryajohary.collegedirectory.services;

import com.aryajohary.collegedirectory.repos.StudentProfileRepository;
import com.aryajohary.collegedirectory.schemas.FacultyProfile;
import com.aryajohary.collegedirectory.schemas.StudentProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentProfileService {

    @Autowired
    private StudentProfileRepository studentProfileRepository;

    public StudentProfile save(StudentProfile studentProfile) {
        return studentProfileRepository.save(studentProfile);
    }

    public List<StudentProfile> saveAll(List<StudentProfile> studentProfileList){
        return studentProfileRepository.saveAll(studentProfileList);
    }

    public List<StudentProfile> findAll() {
        return studentProfileRepository.findAll();
    }

    public StudentProfile findById(Long id) {
        return studentProfileRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        studentProfileRepository.deleteById(id);
    }

    public long size(){
        return studentProfileRepository.count();
    }
    // i have created this custom method to do this
    // as mentioned in the main assignment file

    // Fetch and display advisor details from the database

    public List<FacultyProfile> findFacultyForStudent(Long id){
        return studentProfileRepository.findFacultyForStudent(id);
    }

}