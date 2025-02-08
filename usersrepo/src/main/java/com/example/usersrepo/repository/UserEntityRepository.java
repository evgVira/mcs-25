package com.example.usersrepo.repository;

import com.example.usersrepo.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, UUID> {

    boolean existsUserEntityByEmail(String email);

    Optional<UserEntity> findUserEntityByEmail(String email);

    @Query(value = "select * from users.user_t where user_id in :userIds", nativeQuery = true)
    List<UserEntity> findAllUserEntitiesByIds(@Param("userIds") List<UUID> userIds);
}
