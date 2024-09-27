package com.aryajohary.collegedirectory.repos;

import com.aryajohary.collegedirectory.schemas.FacultyProfile;
import com.aryajohary.collegedirectory.schemas.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {


    // i have used custom jpql query to find all the related faculties to a single
    // student
    // although i needed to show only a limited portion of the FacultyProfile,
    // but due to time constraints, I am showing the full profile for now

    // also, in jpql, we only need the class names and variables to create a query
    // we don't need to specify the table name and other column names because
    // jpql will handle it internally. naming the class name only is the correct behaviour here

    @Query("SELECT f " +
            "FROM Enrollment e " +
            "JOIN e.studentProfile s " +
            "JOIN e.course c " +
            "JOIN c.facultyProfile f " +
            "WHERE s.id = :studentId")
    List<FacultyProfile> findFacultyForStudent(@Param("studentId") Long studentId);

}
