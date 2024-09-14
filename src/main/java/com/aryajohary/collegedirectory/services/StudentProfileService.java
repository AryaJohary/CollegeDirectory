package com.aryajohary.collegedirectory.services;

import com.aryajohary.collegedirectory.repos.StudentProfileRepository;
import com.aryajohary.collegedirectory.schemas.StudentProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentProfileService {

    private StudentProfileRepository studentProfileRepository;

    @Autowired
    public StudentProfileService(StudentProfileRepository studentProfileRepository) {
        this.studentProfileRepository = studentProfileRepository;
    }

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
}