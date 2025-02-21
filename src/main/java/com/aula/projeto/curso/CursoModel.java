package com.aula.projeto.curso;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity(name = "tb_curso")
public class CursoModel {


    @Id
    @GeneratedValue(generator = "UUID")
    private UUID idcurso;
    private  String nomeCurso;
}
