package com.aula.projeto.user;


import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

import java.util.UUID;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import at.favre.lib.crypto.bcrypt.BCrypt;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserRepository userRepository;

  /*   @PostMapping("/novo")
    private UserModel criar(@RequestBody UserModel userModel, HttpServletRequest request){
        System.out.println("TESTE O SISTEMA CHEGOU AQUI");
        var criado = this.userRespositoy.save(userModel);
        return criado;

    }*/

    @GetMapping("novo")
    private ModelAndView criarUsuario() {
        ModelAndView mv = new ModelAndView("createuser");
        mv.addObject("userModel", new UserModel());
        return mv;

    }


    @PostMapping( "/novo")
    private ResponseEntity criarUsuario(@Valid UserModel userModel, HttpServletRequest request){
        var usuarioExiste = this.userRepository.findByUsername(userModel.getUsername());
        if(usuarioExiste != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("usuario cadastrado");

        }else {
           var senhaHash = BCrypt.withDefaults()
                .hashToString(12, userModel.getSenha().toCharArray());
            userModel.setSenha(senhaHash);
            var criado = this.userRepository.save(userModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(criado);
        }

    }

    @GetMapping("/usercadastrados")
    public List<UserModel> listarCursos() {
        List<UserModel> usuariocad = userRepository.findAll();
        return usuariocad;
    }

    @PostMapping("/atualiza")
    public void atualizaUser( UserModel userModel, UUID id ) {
        System.out.println("cheguei aqui");
        var usuario = this.userRepository.findById(id);

        var usuario1 = this.userRepository.save(userModel);
        System.out.println("cheguei aqui FINAL CONTROLLER POST ATULIZA");


    }


//    @GetMapping("/atualiza")
//    public ModelAndView atualizaUser( String username) {
//        ModelAndView mdat = new ModelAndView("update");
//        mdat.addObject("userModel", userRepository.findByUsername(username));
//        return mdat;
//    }



    @GetMapping("/atualiza")
    private ModelAndView atualizaUser() {
        ModelAndView mdat = new ModelAndView("update");
        mdat.addObject("userModel", new UserModel());
        return mdat;

    }

    @GetMapping("/home")
    public String selection(){
        return "home";
    }



    @DeleteMapping("/deletauser/{id}")
    public void deletaUser(@PathVariable UUID id){
        userRepository.deleteById(id);
        
    
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
