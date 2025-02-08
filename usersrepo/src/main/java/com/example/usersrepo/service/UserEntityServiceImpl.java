package com.example.usersrepo.service;

import com.example.usersrepo.dto.request.UserEntityCreateRequestDto;
import com.example.usersrepo.dto.request.UserEntityUpdateRequestDto;
import com.example.usersrepo.dto.response.UserEntityCreateResponseDto;
import com.example.usersrepo.dto.response.UserEntityInfoResponseDto;
import com.example.usersrepo.dto.response.UserEntityUpdateResponseDto;
import com.example.usersrepo.mapper.UserEntityMapper;
import com.example.usersrepo.model.UserEntity;
import com.example.usersrepo.repository.UserEntityRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class UserEntityServiceImpl implements UserEntityService {

    private final static String USER_WITH_ID_NOT_FOUND = "User with id: %s not found";

    private final static String USER_WITH_EMAIL_NOT_FOUND = "User with email: %s not found";

    private final static String USER_WITH_EMAIL_ALREADY_EXISTS = "User with email: %s already exists";

    private final UserEntityRepository userEntityRepository;

    private final UserEntityMapper userEntityMapper;

    @Override
    @Transactional
    public UserEntityCreateResponseDto createUser(UserEntityCreateRequestDto userEntityCreateRequestDto) {
        if (existsByEmail(userEntityCreateRequestDto.getEmail())) {
            log.warn(String.format(USER_WITH_EMAIL_ALREADY_EXISTS, userEntityCreateRequestDto.getEmail()));
            throw new IllegalArgumentException(USER_WITH_EMAIL_ALREADY_EXISTS);
        }
        UserEntity user = userEntityMapper.mapToUserEntity(userEntityCreateRequestDto);
        userEntityRepository.save(user);
        log.info("user was saved");
        return userEntityMapper.mapToUserEntityCreateResponseDto(user);
    }

    @Override
    @Transactional
    public void deleteUser(UUID userId) {
        UserEntity user = findUserById(userId);
        userEntityRepository.delete(user);
        log.info("user was deleted");
    }

    @Override
    @Transactional
    public UserEntityUpdateResponseDto updateUser(UserEntityUpdateRequestDto userEntityUpdateRequestDto) {
        UserEntity user = findUserByEmail(userEntityUpdateRequestDto.getEmail());
        UserEntity updatedUser = userEntityMapper.updateUser(user, userEntityUpdateRequestDto);
        userEntityRepository.save(updatedUser);
        log.info("user was updated");
        return userEntityMapper.mapToUserEntityUpdateResponseDto(user);
    }

    @Override
    public UserEntityInfoResponseDto getUserInfoById(UUID userId) {
        UserEntity user = findUserById(userId);
        return userEntityMapper.mapToUserEntityIntoResponseDto(user);
    }

    @Override
    public List<UserEntityInfoResponseDto> getUsersInfoByIds(List<UUID> userIds) {
        List<UserEntity> userEntities = userEntityRepository.findAllUserEntitiesByIds(userIds);
        return userEntities.stream()
                .map(userEntityMapper::mapToUserEntityIntoResponseDto)
                .toList();
    }

    private UserEntity findUserById(UUID userId) {
        Optional<UserEntity> user = userEntityRepository.findById(userId);
        if (user.isEmpty()) {
            throw new EntityNotFoundException(String.format(USER_WITH_ID_NOT_FOUND, userId));
        }
        return user.get();
    }

    private UserEntity findUserByEmail(String email) {
        Optional<UserEntity> user = userEntityRepository.findUserEntityByEmail(email);
        if (user.isEmpty()) {
            throw new EntityNotFoundException(String.format(USER_WITH_EMAIL_NOT_FOUND, email));
        }
        return user.get();
    }

    private boolean existsByEmail(String email) {
        return userEntityRepository.existsUserEntityByEmail(email);
    }
}
