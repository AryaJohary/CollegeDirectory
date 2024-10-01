package com.aryajohary.collegedirectory.security;

import com.aryajohary.collegedirectory.repos.UserRepo;
import com.aryajohary.collegedirectory.schemas.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;


    // since i am using custom tables, i need to specify the
    // user details here. I have queried the database using the userService and
    // if username is present in database, I have used the UserPrincipal
    // to later set the username and password from the user and also the remaining fields

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if(user==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }
        return new UserPrincipal(user);
    }
}
