/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.model.Service.Impl;

import com.ncs.masterAuto.domain.bean.Client;
import com.ncs.masterAuto.domain.model.Service.ClientService;
import com.ncs.masterAuto.domain.model.Service.RdvService;
import com.ncs.masterAuto.domain.model.dao.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author wadie
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao clientDao;
    @Autowired
    private RdvService rdvService;

    public ClientDao getClientDao() {
        return clientDao;
    }

    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public RdvService getRdvService() {
        return rdvService;
    }

    public void setRdvService(RdvService rdvService) {
        this.rdvService = rdvService;
    }

    //*******************************************************//
    @Override
    public Client seConnecter(String adresseMail, String pwd) {
        Client client = clientDao.findByadresseMail(adresseMail);
        if (client == null || !client.getPwd().equals(pwd)) {
            return null;
        } else {
            return client;
        }
    }

    @Override
    public int createCompte(Client client) {
        Client c = clientDao.findByadresseMail(client.getAdresseMail());
        if (client == null) {
            return -1;
        } else if (!client.getPwd().equals(client.getPwdConfirmation())) {
            return -2;
        } else if (c != null) {
            return -3;
        } else {
            clientDao.save(client);
            return 1;
        }
    }

    @Override
    public Client findByAdresseMail(String AdresseMail) {
        return clientDao.findByadresseMail(AdresseMail);
    }

}
