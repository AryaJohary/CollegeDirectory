package com.aryajohary.collegedirectory.repos;

import com.aryajohary.collegedirectory.schemas.StudentProfile;
import com.aryajohary.collegedirectory.schemas.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String userName);
}
