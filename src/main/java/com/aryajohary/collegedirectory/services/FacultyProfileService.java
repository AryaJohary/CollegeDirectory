package com.aryajohary.collegedirectory.services;

import com.aryajohary.collegedirectory.repos.FacultyProfileRepository;
import com.aryajohary.collegedirectory.schemas.FacultyProfile;
import com.aryajohary.collegedirectory.schemas.StudentProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyProfileService {

    private FacultyProfileRepository facultyProfileRepository;

    @Autowired
    public FacultyProfileService(FacultyProfileRepository facultyProfileRepository) {
        this.facultyProfileRepository = facultyProfileRepository;
    }

    public FacultyProfile save(FacultyProfile facultyProfile) {
        return facultyProfileRepository.save(facultyProfile);
    }

    public List<FacultyProfile> saveAll(List<FacultyProfile> facultyProfileList) {
        return facultyProfileRepository.saveAll(facultyProfileList);
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

    public long size(){
        return facultyProfileRepository.count();
    }

    // i have created this custom method to do this
    // as mentioned in the main assignment file

    // Fetch and display class list from the database.


    public List<StudentProfile> listStudents(Long id){
        return facultyProfileRepository.findStudentsInFacultyCourses(id);
    }

}