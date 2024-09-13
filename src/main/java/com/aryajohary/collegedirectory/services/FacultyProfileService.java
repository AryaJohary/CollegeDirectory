package com.aryajohary.collegedirectory.services;

import com.aryajohary.collegedirectory.repos.FacultyProfileRepository;
import com.aryajohary.collegedirectory.schemas.FacultyProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyProfileService {
    @Autowired
    private FacultyProfileRepository facultyProfileRepository;

    public FacultyProfile save(FacultyProfile facultyProfile) {
        return facultyProfileRepository.save(facultyProfile);
    }

    public List<FacultyProfile> findAll() {
        return facultyProfileRepository.findAll();
    }

    public FacultyProfile findById(Long id) {
        return facultyProfileRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        facultyProfileRepository.deleteById(id);
    }
}