/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.model.Service.Impl;

import com.ncs.masterAuto.domain.bean.Client;
import com.ncs.masterAuto.domain.bean.Rdv;
import com.ncs.masterAuto.domain.bean.Technicien;
import com.ncs.masterAuto.domain.model.Service.ClientService;
import com.ncs.masterAuto.domain.model.Service.RdvService;
import com.ncs.masterAuto.domain.model.Service.TechnicienService;
import com.ncs.masterAuto.domain.model.dao.RdvDao;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author wadie
 */
@Service
public class RdvServiceImpl implements RdvService {

    @Autowired
    private RdvDao rdvDao;
    @Autowired
    private ClientService clientService;
    @Autowired
    private TechnicienService technicienService;

    public RdvDao getRdvDao() {
        return rdvDao;
    }

    public void setRdvDao(RdvDao rdvDao) {
        this.rdvDao = rdvDao;
    }

    public ClientService getClientService() {
        return clientService;
    }

    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    public TechnicienService getTechnicienService() {
        return technicienService;
    }

    public void setTechnicienService(TechnicienService technicienService) {
        this.technicienService = technicienService;
    }

    //****************************//
    @Override
    public Rdv findByClient(Client client) {
        return rdvDao.findByClient(client);
    }

    @Override
    public Rdv findByTechnicien(Technicien technicien) {
        return rdvDao.findByTechnicien(technicien);
    }

    @Override
    public Rdv findByDateRdv(Date dateRdv) {
        return rdvDao.findByDateRdv(dateRdv);
    }

    @Override
    public int createRdv(Rdv rdv, String AdresseMail, String loginTech) {
        Client client = clientService.findByAdresseMail(AdresseMail);
        Technicien technicien = technicienService.findByLogin(loginTech);
        if (client == null || technicien == null || rdv.getDateRdv() == null) {
            return -1;
        } else {
            rdv.setClient(client);
            rdv.setTechnicien(technicien);
            rdvDao.save(rdv);
            return 1;
        }

    }

}