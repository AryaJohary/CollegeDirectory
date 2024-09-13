package com.aryajohary.collegedirectory.repos;


import com.aryajohary.collegedirectory.schemas.FacultyProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyProfileRepository extends JpaRepository<FacultyProfile, Long> {
}
