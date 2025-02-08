package com.example.usersrepo.mapper;

import com.example.usersrepo.dto.request.UserEntityCreateRequestDto;
import com.example.usersrepo.dto.request.UserEntityUpdateRequestDto;
import com.example.usersrepo.dto.response.UserEntityCreateResponseDto;
import com.example.usersrepo.dto.response.UserEntityInfoResponseDto;
import com.example.usersrepo.dto.response.UserEntityUpdateResponseDto;
import com.example.usersrepo.model.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapper {

    public UserEntity mapToUserEntity(UserEntityCreateRequestDto userEntityCreateRequestDto) {
        return UserEntity.builder()
                .username(userEntityCreateRequestDto.getUsername())
                .password(userEntityCreateRequestDto.getPassword())
                .email(userEntityCreateRequestDto.getEmail())
                .build();
    }

    public UserEntity updateUser(UserEntity user, UserEntityUpdateRequestDto userEntityUpdateRequestDto) {
        user.setUsername(userEntityUpdateRequestDto.getUsername());
        user.setPassword(userEntityUpdateRequestDto.getPassword());
        user.setEmail(userEntityUpdateRequestDto.getEmail());
        return user;
    }

    public UserEntityCreateResponseDto mapToUserEntityCreateResponseDto(UserEntity user) {
        return UserEntityCreateResponseDto.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .build();
    }

    public UserEntityUpdateResponseDto mapToUserEntityUpdateResponseDto(UserEntity user) {
        return UserEntityUpdateResponseDto.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .build();
    }

    public UserEntityInfoResponseDto mapToUserEntityIntoResponseDto(UserEntity user) {
        return UserEntityInfoResponseDto.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .build();
    }
}
