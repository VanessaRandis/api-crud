package com.aula.projeto.curso;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import java.util.UUID;




@Entity(name = "tb_curso")
public class CursoModel {


    @Id
    @GeneratedValue(generator = "UUID")
    private UUID idcurso;
    private String nomeCurso;
    private int quantidadeSemestre;

    private UUID idUser;

    public UUID getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(UUID idcurso) {
        this.idcurso = idcurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public int getQuantidadeSemestre() {
        return quantidadeSemestre;
    }

    public void setQuantidadeSemestre(int quantidadeSemestre) {
        this.quantidadeSemestre = quantidadeSemestre;
    }

    public UUID getIdUser() {
        return idUser;
    }

    public void setIdUser(UUID idUser) {
        this.idUser = idUser;
    }
}
