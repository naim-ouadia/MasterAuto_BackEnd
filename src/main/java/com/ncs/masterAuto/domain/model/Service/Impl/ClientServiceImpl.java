/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.model.Service.Impl;

import com.ncs.masterAuto.domain.bean.Client;
import com.ncs.masterAuto.domain.model.Service.ClientService;
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
    ClientDao clientDao;

    public ClientDao getClientDao() {
        return clientDao;
    }

    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

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
        if (client == null) {
            return -1;
        } else if (!client.getPwd().equals(client.getPwdConfirmation())) {
            return -2;
        } else {
            clientDao.save(client);
            return 1;
        }
    }

}
