package com.aula.projeto.user;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private IUserRespositoy userRespositoy;

    @PostMapping("/novo")
    private UserModel criar(@RequestBody UserModel userModel){
        System.out.println("TESTE O SISTEMA CHEGOU AQUI");
        var criado = this.userRespositoy.save(userModel);
        return criado;

    }

    /*
    @GetMapping
    @PostMapping
    @PutMapping
    @DeleteMapping
    @PatchMapping
    
    */




    
}
