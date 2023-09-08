package com.example.newsApps.services.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.newsApps.models.Role;
import com.example.newsApps.models.User;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserDetailsService implements UserDetails{
    private Collection<? extends GrantedAuthority> authorities;
    private String password;
    private String username;
    private Boolean isDeleted;

    public static UserDetails buid(User user) {
        /*
         * menyimpan role lebih dari 1.
         * bisa looping bagian role dan tambahkan ke list authorities       
         */

        Set<Role> roles = user.getRoles();
        Set<String> strRoles = new HashSet<>();
        roles.forEach(role -> {
            strRoles.add(role.getName());
        });

        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(strRoles);
        return new UserDetailsService(authorities, user.getPassword(), user.getUsername(), user.getIsDeleted());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
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
        return !this.isDeleted;
    }

}
