package com.aula.projeto.user;


import java.util.UUID;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import jakarta.persistence.GeneratedValue;

import org.hibernate.validator.constraints.Length;

@Data
@Entity(name = "tb_usuario")
@Table(name = "tb_usuario")
public class UserModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String nome;
    private String cpf;

    @Pattern(regexp = "^(?!\\s*$).+", message = "O campo [username] Deve conter um formato de email válido")
    private String username;

    @Length(min = 10, max = 100)
    private String senha;
    private String telefone;

    @Email(message = "O campo [email] Deve conter um formato de email válido")
    private String email;


}
