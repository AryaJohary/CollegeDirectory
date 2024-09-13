package com.aryajohary.collegedirectory.repos;

import com.aryajohary.collegedirectory.schemas.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}
