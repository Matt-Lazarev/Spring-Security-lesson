package com.lazarev.springsecuritylesson.config;

import com.lazarev.springsecuritylesson.entity.ApplicationUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@RequiredArgsConstructor
public class SecurityUser implements UserDetails {
    private final ApplicationUser user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 2 role , 5 authorities    (10 authority + 2 role) = 12
        return user.getRoles()
                .stream()
                .map(SecurityRole::new)
                .toList();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
