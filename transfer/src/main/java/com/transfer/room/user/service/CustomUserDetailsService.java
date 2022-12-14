package com.transfer.room.user.service;

import com.transfer.room.user.dto.CustomUserDetails;
import com.transfer.room.user.dto.UserDto;
import com.transfer.room.user.dto.UserRoleDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
// CustomUserDbService는 인터페이스다. 해당 인터페이스를 구현하고 있는 객체가 Bean으로 등록되어 있어야 한다.
public class CustomUserDetailsService implements UserDetailsService {
    private static final String USER_NOT_FOUND_EXCEPTION_MESSAGE = "User Not Found Excepction";
    private final UserService userService;
    public CustomUserDetailsService(UserService userService){
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        // loginId에 해당하는 정보를 데이터베이스에서 읽어 CustomUser객체에 저장한다.
        // 해당 정보를 CustomUserDetails객체에 저장한다.
        UserDto userDto = userService.findUserByUserEmail(userEmail);

        if(userDto == null){
            throw new UsernameNotFoundException(USER_NOT_FOUND_EXCEPTION_MESSAGE);
        }

        CustomUserDetails customUserDetails = new CustomUserDetails(userDto);
        int userId = userDto.getUserId();
        List<UserRoleDto> customRoles = userService.findUserRoleByUserId(userId);

        // 로그인 한 사용자의 권한 정보를 GrantedAuthority를 구현하고 있는 SimpleGrantedAuthority객체에 담아
        // 리스트에 추가한다. UserRole 이름은 "ROLE_"로 시작되야 한다.
        List<GrantedAuthority> authorities = new ArrayList<>();

        if (customRoles != null) {
            for (UserRoleDto customRole : customRoles) {
                authorities.add(new SimpleGrantedAuthority(customRole.getRoleName()));
            }
        }

        // CustomUserDetails객체에 권한 목록 (authorities)를 설정한다.
        customUserDetails.setAuthorities(authorities);
        customUserDetails.setEnabled(true);
        customUserDetails.setAccountNonExpired(true);
        customUserDetails.setAccountNonLocked(true);
        customUserDetails.setCredentialsNonExpired(true);
        return customUserDetails;
    }
}