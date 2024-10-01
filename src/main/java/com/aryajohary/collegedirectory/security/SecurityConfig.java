package com.aryajohary.collegedirectory.security;

import com.aryajohary.collegedirectory.schemas.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
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
                        .requestMatchers("/studentProfiles/**").hasAnyAuthority(String.valueOf(Role.Student), String.valueOf(Role.Administrator))
                        .requestMatchers("/facultyprofiles/**").hasAnyAuthority(String.valueOf(Role.Faculty_Member), String.valueOf(Role.Administrator))
                        .requestMatchers("/administratorProfiles/**").hasAuthority(String.valueOf(Role.Administrator))
                        .anyRequest().authenticated()
                        )
                        .formLogin(form -> form
                                .loginPage("/")
                                .loginProcessingUrl("authenticateTheUser")
                                .permitAll()
                        );
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf->csrf.disable());
        return http.build();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
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
