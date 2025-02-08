package com.example.usersrepo.controller;

import com.example.usersrepo.dto.request.UserEntityCreateRequestDto;
import com.example.usersrepo.dto.request.UserEntityUpdateRequestDto;
import com.example.usersrepo.dto.response.UserEntityCreateResponseDto;
import com.example.usersrepo.dto.response.UserEntityInfoResponseDto;
import com.example.usersrepo.dto.response.UserEntityUpdateResponseDto;
import com.example.usersrepo.service.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserEntityService userEntityService;

    @GetMapping("/{userId}/info")
    public UserEntityInfoResponseDto getUserInfoById(@PathVariable("userId") UUID userId) {
        return userEntityService.getUserInfoById(userId);
    }

    @PostMapping("/create")
    public UserEntityCreateResponseDto createUser(@RequestBody UserEntityCreateRequestDto userEntityCreateRequestDto) {
        return userEntityService.createUser(userEntityCreateRequestDto);
    }

    @DeleteMapping("/{userId}/delete")
    public void deleteUser(@PathVariable("userId") UUID userId) {
        userEntityService.deleteUser(userId);
    }

    @PutMapping("/update")
    public UserEntityUpdateResponseDto updateUser(@RequestBody UserEntityUpdateRequestDto userEntityUpdateRequestDto) {
        return userEntityService.updateUser(userEntityUpdateRequestDto);
    }

    @GetMapping("/info")
    public List<UserEntityInfoResponseDto> getUserInfoByIds(@RequestParam("userId") List<UUID> userId) {
        return userEntityService.getUsersInfoByIds(userId);
    }

}
