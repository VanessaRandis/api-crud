package com.aula.projeto.user;


import com.aula.projeto.filter.FilterAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class AuthUserController {

    @Autowired
    private FilterAuth filterauth;


    @PostMapping("/auth")
    public ResponseEntity<Object> auth(@RequestBody FilterAuth filter) {

        try {

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());

        }
        return null;
    }


}
