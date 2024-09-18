package com.aryajohary.collegedirectory.services;

import com.aryajohary.collegedirectory.repos.EnrollmentRepository;
import com.aryajohary.collegedirectory.schemas.Enrollment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {

    private EnrollmentRepository enrollmentRepository;

    @Autowired
    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public Enrollment save(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    public List<Enrollment> saveAll(List<Enrollment> enrollmentList){
        return enrollmentRepository.saveAll(enrollmentList);
    }

    public List<Enrollment> findAll() {
        return enrollmentRepository.findAll();
    }

    public Enrollment findById(Long id) {
        return enrollmentRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        enrollmentRepository.deleteById(id);
    }

    public long size(){
        return enrollmentRepository.count();
    }

}