/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.model.Service.Impl;

import com.ncs.masterAuto.domain.bean.Client;
import com.ncs.masterAuto.domain.bean.Rdv;
import com.ncs.masterAuto.domain.bean.Technicien;
import com.ncs.masterAuto.domain.model.Service.RdvService;
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
    
    public RdvDao getRdvDao() {
        return rdvDao;
    }
    
    public void setRdvDao(RdvDao rdvDao) {
        this.rdvDao = rdvDao;
    }

    //****************************//
    @Override
    public int createRdv(Rdv rdv) {
        Rdv r = rdvDao.findByClient(rdv.getClient());
        Rdv r2 = rdvDao.findByDateRdv(r.getDateRdv());
        Rdv r3 = rdvDao.findByTechnicien(r2.getTechnicien());
        if (rdv == null) {
            return -2;
        } else if (r3 != null) {
            return -2;
        } else {
            rdvDao.save(rdv);
            return 1;
        }
    }
    
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
    
}
