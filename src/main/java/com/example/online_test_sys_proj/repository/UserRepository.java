package com.example.online_test_sys_proj.repository;

import com.example.online_test_sys_proj.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<UserEntity,Long> {

    Optional<UserEntity> findUserByEmail(String email);
}
