package com.example.authrepo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserCreateResponseDto {

    private UUID userId;

    private String username;

    private String password;

    private String email;

}
