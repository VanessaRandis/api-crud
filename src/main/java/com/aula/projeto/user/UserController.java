package com.aula.projeto.user;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserRespositoy userRespositoy;

    @PostMapping("/novo")
    private UserModel criar(@RequestBody UserModel userModel, HttpServletRequest request){
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
