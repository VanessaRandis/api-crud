package com.aula.projeto.filter;

import java.io.IOException;
import java.util.Base64;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.aula.projeto.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class FilterAuth extends OncePerRequestFilter{

    @Autowired
    IUserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

            var serveletPath = request.getServletPath();
            if(serveletPath.equals("/curso/criar") || serveletPath.equals("/tarefa/nova")){
                        var authorization = request.getHeader("Authorization");
                        var authEncode = authorization.substring("Basic".length()).trim();
                        byte [] authDecode = Base64.getDecoder().decode(authEncode);

                        System.out.println("Authorization");
                        System.out.println(authDecode);

                        var authString = new String(authDecode);
                        String [] credenciais = authString.split(":");
                        String username = credenciais[0];
                        String senha = credenciais[1];

                        System.out.println(username);
                        System.out.println(senha);


                        //VALIDAÇÃO DE USUARIO

                        var user = this.userRepository.findByUsername(username);
                        if(user == null){
                            response.sendError(401,"usuario sem autorização");
                        }else {
                            var verificaSenha = BCrypt.verifyer().verify(senha.toCharArray(), user.getSenha());
                            if(verificaSenha.verified) {
                                request.setAttribute("idUser", user.getId()); // incluir para setar toda vez que fizer a autenticação atribuindo idUser no objeto
                                filterChain.doFilter(request, response);
                            } else {
                                response.sendError(401);
                            }

                        }
                    } else {
                        filterChain.doFilter(request, response);
                    }

    }

}

