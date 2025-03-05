package com.aula.projeto.user;


import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserRespositoy userRespositoy;

  /*   @PostMapping("/novo")
    private UserModel criar(@RequestBody UserModel userModel, HttpServletRequest request){
        System.out.println("TESTE O SISTEMA CHEGOU AQUI");
        var criado = this.userRespositoy.save(userModel);
        return criado;

    }*/

    @PostMapping("/novo")
    private ResponseEntity criarUusario(@RequestBody UserModel userModel, HttpServletRequest request){
        var usuarioExiste = this.userRespositoy.findByNome(userModel.getNome());
        if(usuarioExiste != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("usuario cadastrado");

        }else {
            System.out.println("TESTE O SISTEMA CHEGOU AQUI");
            var criado = this.userRespositoy.save(userModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(criado);
        }

    }

    @GetMapping("/usercadastrados")
    public List<UserModel> listarCursos() {
        List<UserModel> usuariocad = userRespositoy.findAll();
        return usuariocad;
    }

    @PutMapping("/atualizauser")
    public ResponseEntity atualizaUser(@RequestBody UserModel userModel) {   
        var criado = this.userRespositoy.save(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @DeleteMapping("/deletauser/{id}")
    public void deletaUser(@PathVariable UUID id){
        userRespositoy.deleteById(id);
        
    
    }

    // Esta funcionando, agora deve ser aplicado a lógica para caso exista o usuário para que não deixe inserir novamente.
    // Deve ser verificado o username || nome



    /*
    @GetMapping ok
    @PostMapping ok 
    @PutMapping ok 
    @DeleteMapping ok
    @PatchMapping
    
    */

    //crud -->  create - read - update - delete 




    
}
