package com.aryajohary.collegedirectory.repos;

import com.aryajohary.collegedirectory.schemas.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
