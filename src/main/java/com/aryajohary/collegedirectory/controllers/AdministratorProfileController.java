package com.aryajohary.collegedirectory.controllers;

import com.aryajohary.collegedirectory.schemas.AdministratorProfile;
import com.aryajohary.collegedirectory.services.AdministratorProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administratorProfiles")
public class AdministratorProfileController {
    @Autowired
    private AdministratorProfileService administratorProfileService;

    @PostMapping
    public AdministratorProfile createAdministratorProfile(@RequestBody AdministratorProfile administratorProfile) {
        return administratorProfileService.save(administratorProfile);
    }

    @GetMapping
    public List<AdministratorProfile> getAllAdministratorProfiles() {
        return administratorProfileService.findAll();
    }

    @GetMapping("/{id}")
    public AdministratorProfile getAdministratorProfileById(@PathVariable Long id) {
        return administratorProfileService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAdministratorProfile(@PathVariable Long id) {
        administratorProfileService.deleteById(id);
    }
}