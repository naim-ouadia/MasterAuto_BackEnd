/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ncs.masterAuto.domain.bean.Client;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 *
 * @author wadie
 */
public class JWTAuthentificationFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            Client client = new ObjectMapper().readValue(request.getInputStream(), Client.class);
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(client.getAdresseMail(), client.getPwd()));

        } catch (IOException ex) {
            Logger.getLogger(JWTAuthentificationFilter.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new RuntimeException("pb dans le contenue de la requete");
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult); //To change body of generated methods, choose Tools | Templates.
    }

}
