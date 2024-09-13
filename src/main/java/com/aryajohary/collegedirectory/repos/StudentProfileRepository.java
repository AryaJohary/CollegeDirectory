package com.aryajohary.collegedirectory.repos;

import com.aryajohary.collegedirectory.schemas.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {
}
