package com.devang.jwtAuth.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devang.jwtAuth.models.AppUsers;

@Repository
public interface MyUserRepository extends JpaRepository<AppUsers, String> {
    AppUsers findUserByUsername(String username);
}