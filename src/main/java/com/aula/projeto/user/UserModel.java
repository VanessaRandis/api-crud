package com.aula.projeto.user;

import java.util.UUID;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import jakarta.persistence.GeneratedValue;

@Data
@Entity(name = "tb_usuario")
public class UserModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    
    private String nome;
    private String username;
    private String senha;
    private String telefone;
    private String email;


}
