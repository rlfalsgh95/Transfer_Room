package com.transfer.room.user.mapper;

import com.transfer.room.user.UserRole;
import com.transfer.room.user.dto.UserDto;
import com.transfer.room.user.dto.UserRoleDto;
import com.transfer.room.user.entity.UserEntity;
import com.transfer.room.user.entity.UserRoleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    UserDto selectUserByUserId(int userId); // userId를 이용한 유저 정보 조회 메서드
    UserDto selectUserByUserEmail(String userEmail);
    int updateUser(UserEntity userEntity) throws Exception; // 유저 정보 수정 메서드
    int insertUser(UserEntity userEntity) throws Exception;   // 유저 정보 생성 메서드

    List<UserRoleDto> selectUserRoleByUserId(int userId); // userId를 이용한 유저 권한 조회 메서드
    int insertUserRole(UserRoleEntity userRoleEntity);  // 유저 권한 생성 메서드
    int deleteUserRole(int userId, int roleId);   // 유저 권한 삭제 메서드

    UserRoleDto selectRoleByRoleName(UserRole roleName);
}
