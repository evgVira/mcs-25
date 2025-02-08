package com.example.authrepo.mapper;

import com.example.authrepo.dto.request.RegistrationUserRequestDto;
import com.example.authrepo.dto.request.UserEntityCreateRequestDto;
import com.example.authrepo.dto.response.RegistrationUserResponseDto;
import com.example.authrepo.dto.response.UserCreateResponseDto;
import com.example.authrepo.model.UserEntityAuth;
import com.example.authrepo.model.Role;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthUserMapper {

    public UserEntityCreateRequestDto mapToUserEntityCreateRequestDto(RegistrationUserRequestDto registrationUserRequestDto) {
        return UserEntityCreateRequestDto.builder()
                .username(registrationUserRequestDto.getUsername())
                .password(registrationUserRequestDto.getPassword())
                .email(registrationUserRequestDto.getEmail())
                .build();
    }

    public UserEntityAuth mapToUserEntityAuth(UserCreateResponseDto userCreateResponseDto, List<Role> roleList) {
        return UserEntityAuth.builder()
                .userId(userCreateResponseDto.getUserId())
                .username(userCreateResponseDto.getEmail())
                .password(userCreateResponseDto.getPassword())
                .roles(roleList)
                .build();
    }

    public RegistrationUserResponseDto mapToRegistrationUserResponseDto(UserEntityAuth userEntityAuth) {
        return RegistrationUserResponseDto.builder()
                .userId(userEntityAuth.getUserId())
                .username(userEntityAuth.getUsername())
                .build();
    }
}
