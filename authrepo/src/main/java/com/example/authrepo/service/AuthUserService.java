package com.example.authrepo.service;

import com.example.authrepo.dto.request.RegistrationUserRequestDto;
import com.example.authrepo.dto.response.RegistrationUserResponseDto;

public interface AuthUserService {

    RegistrationUserResponseDto registerUser(RegistrationUserRequestDto registrationUserRequestDto);
}
