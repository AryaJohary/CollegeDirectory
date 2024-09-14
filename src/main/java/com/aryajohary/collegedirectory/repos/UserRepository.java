package com.aryajohary.collegedirectory.repos;

import com.aryajohary.collegedirectory.schemas.StudentProfile;
import com.aryajohary.collegedirectory.schemas.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // this is used to query database if the username is present or not
    // if present, return that user, if not return null
    Optional<User> findByUsername(String userName);
}
