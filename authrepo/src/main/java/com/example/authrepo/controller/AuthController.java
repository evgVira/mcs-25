package com.example.authrepo.controller;

import com.example.authrepo.dto.request.RegistrationUserRequestDto;
import com.example.authrepo.dto.response.RegistrationUserResponseDto;
import com.example.authrepo.service.AuthUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthUserService authUserService;

    @PostMapping("/registration")
    public RegistrationUserResponseDto createUser(@RequestBody RegistrationUserRequestDto registrationUserRequestDto) {
        return authUserService.registerUser(registrationUserRequestDto);
    }

}
