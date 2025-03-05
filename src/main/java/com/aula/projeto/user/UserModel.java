package com.aula.projeto.user;


import java.util.UUID;


import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
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
    @NonNull
    private String nome;
    private String cpf;
    @Column(unique = true)
    private String username;
    private String senha;
    private String telefone;
    private String email;



}
