package com.aula.projeto.curso;

import java.util.List;
import java.util.UUID;


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

        var cursoExistente = this.cursoController.findByNomeCurso(cursoModel.getNomeCurso());
        if(cursoExistente != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("curso ja cadastrado");
        }else {
            System.out.println("CHEGOU NO CONTROLER" + request.getAttribute("idUser"));// VERIFICA SE CHEGA A INFORMAÇÃO
            var idUser = request.getAttribute("idUser");// coloca em uma variavel o valor setado do idUser que esta no cursoModel
            cursoModel.setIdUser((UUID) idUser); // aqui faz um casting para que o dado seja UUID
            var cadastro = this.cursoController.save(cursoModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(cadastro);
        }
    }

    @GetMapping("/cursoscadastrados")
    public List<CursoModel> listarCursos() {
        List<CursoModel> cursos = cursoController.findAll();
        return cursos;
    }
    

    @DeleteMapping("/deletacurso/{id}")
    public void deletaCurso(@PathVariable UUID id){
        cursoController.deleteById(id);

    }

    @PutMapping("/atualizacurso")
    public ResponseEntity atualizaCurso(@RequestBody CursoModel cursoModel) {
        var atCurso = cursoController.save(cursoModel);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(atCurso);
    }


}