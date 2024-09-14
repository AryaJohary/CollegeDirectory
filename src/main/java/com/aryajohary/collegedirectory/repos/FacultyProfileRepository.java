package com.aryajohary.collegedirectory.repos;


import com.aryajohary.collegedirectory.schemas.FacultyProfile;
import com.aryajohary.collegedirectory.schemas.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FacultyProfileRepository extends JpaRepository<FacultyProfile, Long> {

    // i have used custom jpql query to find all the related students to a single
    // faculty
    // although i needed to show only a limited portion of the StudentProfile,
    // but due to time constraints, I am showing the full profile for now

    @Query("SELECT s " +
            "FROM Enrollment e " +
            "JOIN e.studentProfile s " +
            "JOIN e.course c " +
            "JOIN c.facultyProfile f " +
            "WHERE f.id = :facultyId")
    List<StudentProfile> findStudentsInFacultyCourses(@Param("facultyId") Long facultyId);

}
