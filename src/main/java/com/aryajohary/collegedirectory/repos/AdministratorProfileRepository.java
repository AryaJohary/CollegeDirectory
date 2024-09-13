package com.aryajohary.collegedirectory.repos;

import com.aryajohary.collegedirectory.schemas.AdministratorProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorProfileRepository extends JpaRepository<AdministratorProfile, Long> {
}
