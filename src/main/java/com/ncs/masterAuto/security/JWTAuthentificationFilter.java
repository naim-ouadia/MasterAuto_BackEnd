/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.security;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ncs.masterAuto.domain.bean.UserAccount;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 *
 * @author wadie
 */
public class JWTAuthentificationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JWTAuthentificationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
//ici décrie les instructures qui va faire le programme si user saisi son username et son password

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            UserAccount userAccount = new ObjectMapper().readValue(request.getInputStream(), UserAccount.class);//diseralisation dejson vers un objet java ( du textJson qui devient Java)
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userAccount.getAdresseMail(), userAccount.getPassword()));

        } catch (IOException ex) {
            ex.printStackTrace();
//            Logger.getLogger(JWTAuthentificationFilter.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }

    }

    //si le user est ok alors = generer un JWT
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
        User user = (User) authResult.getPrincipal();//pour returner l'objet connecter
        List<String> roles = new ArrayList<>();
        authResult.getAuthorities().forEach(a -> { //getAuthorities()pour les roles du User
            roles.add(a.getAuthority());
        });
        String jwt = JWT.create() // la creation du JWT 
                .withIssuer(request.getRequestURI())// le URL  de l'emmeteur(app) qui a generé le Token
                .withSubject(user.getUsername())
                .withArrayClaim("roles", roles.toArray(new String[roles.size()]))//les roles sous forme de tableau de String
                .withExpiresAt(new Date(System.currentTimeMillis() + SecurityPrams.EXPEIRATION))
                .sign(com.auth0.jwt.algorithms.Algorithm.HMAC256(SecurityPrams.SECRET));// le HMAC A TOUJOUR BESOIN D'UN SECRET POUR FONCTIONNER
        response.addHeader(SecurityPrams.JWT_HEADER_NAME, jwt);
    }

}
// dans le JWT on a mis le User et les roles aussi
