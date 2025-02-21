package com.aula.projeto.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRespositoy extends JpaRepository<UserModel, UUID> {


    
}
