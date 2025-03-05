package com.aula.projeto.curso;

import java.util.List;
import java.util.UUID;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private ICursoController cursoController;


    @PostMapping("/criar")
    public ResponseEntity createCurso(@RequestBody CursoModel cursoModel, HttpServletRequest request){
        var cadastro = this.cursoController.save(cursoModel);
        System.out.println(cadastro.getNomeCurso() + cadastro.getQuantidadeSemestre() + cadastro.getQuantidadeSemestre());
        return ResponseEntity.status(HttpStatus.CREATED).body(cadastro);

    }

    @GetMapping("/cursoscadastrados")
    public List<CursoModel> listarCursos() {
        List<CursoModel> cursos = cursoController.findAll();
        return cursos;
    }
    

    @DeleteMapping("/deletacurso/{}")
    public void deletaCurso(@PathVariable UUID id){
        cursoController.deleteById(id);

    }

    @PutMapping("/atualizacurso")
    public ResponseEntity atualizaCurso(@RequestBody CursoModel cursoModel) {
        var atCurso = cursoController.save(cursoModel);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(atCurso);
    }


    /* if(cadastro!= null)
     * 
     */

}