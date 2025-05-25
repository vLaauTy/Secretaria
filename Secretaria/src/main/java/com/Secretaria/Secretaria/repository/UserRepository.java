package com.Secretaria.Secretaria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Secretaria.Secretaria.Model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByUsername(String username);
}
