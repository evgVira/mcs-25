package com.example.authrepo.client;

import com.example.authrepo.dto.request.UserEntityCreateRequestDto;
import com.example.authrepo.dto.response.UserCreateResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class UserServiceClient {

    private final WebClient webClient;

    private static final String BASE_USER_URL = "http://localhost:8081/api/v1/user";

    private static final String CREATE_PATH = "/create";

    public UserCreateResponseDto createUser(UserEntityCreateRequestDto userEntityCreateRequestDto) {
        return webClient.post()
                .uri(BASE_USER_URL + CREATE_PATH)
                .bodyValue(userEntityCreateRequestDto)
                .retrieve()
                .bodyToMono(UserCreateResponseDto.class)
                .block();
    }

}
