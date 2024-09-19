package com.aryajohary.collegedirectory.controllers;

import com.aryajohary.collegedirectory.schemas.Role;
import com.aryajohary.collegedirectory.security.CustomUserDetailsService;
import com.aryajohary.collegedirectory.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    // not finalized yet. but working on it. right now creating the front-end part

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @GetMapping
    public String showLoginForm() {
        return "login/login-page"; // Render the login.html page
    }

    @PostMapping
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("role") String appliedRole,
                        Model model) {
        try {
            UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);

            // Authenticate user
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);

            UserPrincipal userPrincipal = (UserPrincipal) userDetails;

            // Check if the role matches
            Role permittedRole = userPrincipal.getUser().getRole();
            if (permittedRole.toString().equalsIgnoreCase(appliedRole)) {
                // Redirect based on the role
                System.out.println("Role matched");
                switch (permittedRole){
                    case Role.STUDENT -> {
                        return "redirect:/studentProfiles";
                    }
                    case Role.FACULTY_MEMBER -> {
                        return "redirect:/facultyProfiles";
                    }
                    case Role.ADMINISTRATOR -> {
                        return "redirect:/adminProfiles";
                    }
                }
            } else {
                // Role mismatch error
                model.addAttribute("error", "Incorrect role for this user");
                return "login/login-page"; // Stay on login page
            }
        } catch (AuthenticationException e) {
            // Authentication failed, return an error
            model.addAttribute("error", "Invalid username or password");
            return "login/login-page"; // Stay on login page with error
        }
        return "redirect:/";
    }
}
