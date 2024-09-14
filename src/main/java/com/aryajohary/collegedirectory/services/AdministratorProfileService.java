package com.aryajohary.collegedirectory.services;

import com.aryajohary.collegedirectory.repos.AdministratorProfileRepository;
import com.aryajohary.collegedirectory.schemas.AdministratorProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorProfileService {

    private AdministratorProfileRepository administratorProfileRepository;

    @Autowired
    public AdministratorProfileService(AdministratorProfileRepository administratorProfileRepository) {
        this.administratorProfileRepository = administratorProfileRepository;
    }

    public AdministratorProfile save(AdministratorProfile administratorProfile) {
        return administratorProfileRepository.save(administratorProfile);
    }

    public List<AdministratorProfile> saveAll(List<AdministratorProfile> administratorProfileList){
        return administratorProfileRepository.saveAll(administratorProfileList);
    }

    public List<AdministratorProfile> findAll() {
        return administratorProfileRepository.findAll();
    }

    public AdministratorProfile findById(Long id) {
        return administratorProfileRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        administratorProfileRepository.deleteById(id);
    }
}