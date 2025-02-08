package com.example.usersrepo.service;

import com.example.usersrepo.dto.request.UserEntityCreateRequestDto;
import com.example.usersrepo.dto.request.UserEntityUpdateRequestDto;
import com.example.usersrepo.dto.response.UserEntityCreateResponseDto;
import com.example.usersrepo.dto.response.UserEntityInfoResponseDto;
import com.example.usersrepo.dto.response.UserEntityUpdateResponseDto;

import java.util.List;
import java.util.UUID;

public interface UserEntityService {

    UserEntityCreateResponseDto createUser(UserEntityCreateRequestDto userEntityCreateRequestDto);

    void deleteUser(UUID userId);

    UserEntityUpdateResponseDto updateUser(UserEntityUpdateRequestDto userEntityUpdateRequestDto);

    UserEntityInfoResponseDto getUserInfoById(UUID userId);

    List<UserEntityInfoResponseDto> getUsersInfoByIds(List<UUID> userIds);
}
