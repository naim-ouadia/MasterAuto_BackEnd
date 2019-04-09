/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.rest;

import com.ncs.masterAuto.domain.bean.Client;
import com.ncs.masterAuto.domain.model.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wadie
 */
@RestController
@RequestMapping("/master_Auto/clients")
public class ClientRest {

    @Autowired
    ClientService clientService;

    @GetMapping("/adresseMail/{adresseMail}/motDePasse/{pwd}")
    public Client seConnecter(@PathVariable String adresseMail, @PathVariable String pwd) {
        return clientService.seConnecter(adresseMail, pwd);
    }

    @PostMapping("/")
    public int createCompte(@RequestBody Client client) {
        return clientService.createCompte(client);
    }

    //***** getters et setters ******//
    public ClientService getClientService() {
        return clientService;
    }

    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

}
