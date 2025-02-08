package com.example.usersrepo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserEntityCreateResponseDto {

    private UUID userId;

    private String username;

    private String password;

    private String email;

}
