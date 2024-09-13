package com.aryajohary.collegedirectory.repos;

import com.aryajohary.collegedirectory.schemas.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
