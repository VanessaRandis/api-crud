package com.aula.projeto.curso;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.UUID;



@Data
@Entity(name = "tb_curso")
@Table(name = "curso")
public class CursoModel {


    @Id
    @GeneratedValue(generator = "UUID")
    private UUID idcurso;
    private String nomeCurso;
    private int quantidadeSemestre;

    private UUID idUser;


}
