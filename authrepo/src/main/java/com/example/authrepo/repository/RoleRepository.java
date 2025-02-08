package com.example.authrepo.repository;

import com.example.authrepo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {

    @Query(value = "select role_id from auth.users_roles where user_id = :userId", nativeQuery = true)
    List<UUID> findRolesByUserId(@Param("userId") UUID userId);

    Role findRoleByRoleName(String roleName);

    @Query(value = "select * from auth.role_t where role_id in :roleIds", nativeQuery = true)
    List<Role> findRolesByRoleIds(@Param("roleIds") List<UUID> roleIds);
}
