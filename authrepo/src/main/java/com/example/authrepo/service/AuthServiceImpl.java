package com.example.authrepo.service;

import com.example.authrepo.client.UserServiceClient;
import com.example.authrepo.dto.request.RegistrationUserRequestDto;
import com.example.authrepo.dto.request.UserEntityCreateRequestDto;
import com.example.authrepo.dto.response.RegistrationUserResponseDto;
import com.example.authrepo.dto.response.UserCreateResponseDto;
import com.example.authrepo.mapper.AuthUserMapper;
import com.example.authrepo.model.UserEntityAuth;
import com.example.authrepo.model.Role;
import com.example.authrepo.repository.AuthUserRepository;
import com.example.authrepo.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class AuthServiceImpl implements AuthUserService {

    private static final String DEFAULT_USER_ROLE = "ROLE_USER";

    private final UserServiceClient userServiceClient;

    private final AuthUserMapper authUserMapper;

    private final AuthUserRepository authUserRepository;

    private final RoleRepository roleRepository;

    @Override
    @Transactional
    public RegistrationUserResponseDto registerUser(RegistrationUserRequestDto registrationUserRequestDto) {
        UserEntityCreateRequestDto userEntityCreateRequestDto = authUserMapper.mapToUserEntityCreateRequestDto(registrationUserRequestDto);
        UserCreateResponseDto userCreateResponseDto = userServiceClient.createUser(userEntityCreateRequestDto);
        Role defaultRole = roleRepository.findRoleByRoleName(DEFAULT_USER_ROLE);
        UserEntityAuth userEntityAuth = authUserMapper.mapToUserEntityAuth(userCreateResponseDto, List.of(defaultRole));
        authUserRepository.save(userEntityAuth);
        log.info("user was saved");
        return authUserMapper.mapToRegistrationUserResponseDto(userEntityAuth);
    }

}
