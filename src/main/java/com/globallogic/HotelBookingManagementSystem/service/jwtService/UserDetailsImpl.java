package com.globallogic.HotelBookingManagementSystem.service.jwtService;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.globallogic.HotelBookingManagementSystem.entity.Role;
import com.globallogic.HotelBookingManagementSystem.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserDetailsImpl implements UserDetails {

    private static final long serialVersionUID=1L;

    private int id;

    private String username;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(){}

    public UserDetailsImpl(int id, String username, String password,
                           Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(User user) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        Role role = user.getRole();
        System.err.println(role);
        grantedAuthorities.add(new SimpleGrantedAuthority(role.name()));
        return new UserDetailsImpl(
                user.getUserId(),
                user.getUserName(),
                user.getPassword(),
                grantedAuthorities
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public int getId() {
        return id;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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

    @Override
    public boolean equals(Object o)  {
        if(this==o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        return  id == ((UserDetailsImpl) o).getId();
    }
}
