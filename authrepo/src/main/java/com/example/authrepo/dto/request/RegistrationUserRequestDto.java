package com.example.authrepo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RegistrationUserRequestDto {

    private String username;

    private String password;

    private String confirmPassword;

    private String email;

}
