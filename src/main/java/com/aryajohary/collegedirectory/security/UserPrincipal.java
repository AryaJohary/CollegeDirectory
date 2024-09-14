package com.aryajohary.collegedirectory.security;

import com.aryajohary.collegedirectory.schemas.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserPrincipal implements UserDetails {

    // i will use this user variable to later access the role so that I can
    // determine its access level

    private User user;

    public UserPrincipal(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String authority = String.valueOf(user.getRole());
        System.out.println("Granted Authority: " + authority);
        return Collections.singleton(new SimpleGrantedAuthority(authority));
    }


    // getting the username password as is from the user

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    // and since we don't have rest fields in the table itself
    // i will manually mark all the required boolean values true

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }


}
