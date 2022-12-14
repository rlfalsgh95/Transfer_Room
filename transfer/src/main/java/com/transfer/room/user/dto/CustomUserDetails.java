package com.transfer.room.user.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
@Setter
@ToString
public class CustomUserDetails implements UserDetails {
    private int userId;
    private String userEmail;
    private String username;
    private String password;
    private boolean isEnabled;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(){}
    public CustomUserDetails(UserDto userDto){
        this.setUserId(userDto.getUserId());
        this.setUserEmail(userDto.getUserEmail());
        this.setUsername(userDto.getUserName());
        this.setPassword(userDto.getUserPassword());
    }
}