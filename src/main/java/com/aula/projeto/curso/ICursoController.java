package com.aula.projeto.curso;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;



public interface ICursoController extends JpaRepository<CursoModel, UUID> {

 

}
