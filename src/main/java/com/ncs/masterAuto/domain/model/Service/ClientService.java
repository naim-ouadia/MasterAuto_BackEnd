/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.model.Service;

import com.ncs.masterAuto.domain.bean.Client;

/**
 *
 * @author wadie
 */
public interface ClientService {

    public Client findByAdresseMail(String AdresseMail);

    public Client seConnecter(String adresseMail, String pwd);

    public int createCompte(Client client);

}
