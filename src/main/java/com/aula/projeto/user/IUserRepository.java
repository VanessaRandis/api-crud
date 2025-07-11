package com.aula.projeto.user;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;


public interface IUserRepository extends JpaRepository<UserModel, UUID> {

    UserModel findByUsername(String username);
    Optional<UserModel> findById(UUID id);




}


