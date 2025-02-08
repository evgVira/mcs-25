package com.example.authrepo.repository;

import com.example.authrepo.model.UserEntityAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthUserRepository extends JpaRepository<UserEntityAuth, UUID> {

}
