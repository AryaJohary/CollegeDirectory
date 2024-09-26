package com.aryajohary.collegedirectory.services;

import com.aryajohary.collegedirectory.repos.DepartmentRepository;
import com.aryajohary.collegedirectory.schemas.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    public List<Department> saveAll(List<Department> departmentList){
        return departmentRepository.saveAll(departmentList);
    }

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    public Department findById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        departmentRepository.deleteById(id);
    }

    public long size(){
        return departmentRepository.count();
    }
}