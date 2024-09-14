package com.aryajohary.collegedirectory.security;

import com.aryajohary.collegedirectory.schemas.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService userDetailsService;


    // setting up authorities level

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                configurer -> configurer
                        .requestMatchers("/studentProfiles/**").hasAnyAuthority(String.valueOf(Role.STUDENT), String.valueOf(Role.ADMINISTRATOR))
                        .requestMatchers("/facultyprofiles/**").hasAnyAuthority(String.valueOf(Role.FACULTY_MEMBER), String.valueOf(Role.ADMINISTRATOR))
                        .requestMatchers("/administratorProfiles/**").hasAuthority(String.valueOf(Role.ADMINISTRATOR))
                        .anyRequest().authenticated()
        );
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf->csrf.disable());
        return http.build();
    }

    // i am using noop password encoder for simplicity sake

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;

    }

}
