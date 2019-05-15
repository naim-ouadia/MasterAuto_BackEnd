/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.model.Service.Impl;

import com.ncs.masterAuto.domain.bean.Rdv;
import com.ncs.masterAuto.domain.bean.Technicien;
import com.ncs.masterAuto.domain.bean.UserAccount;
import com.ncs.masterAuto.domain.model.Service.AccountService;
import com.ncs.masterAuto.domain.model.Service.RdvService;
import com.ncs.masterAuto.domain.model.dao.RdvDao;
import com.ncs.masterAuto.domain.model.dao.TechnicienDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author wadie
 */
@Service
@Transactional
public class RdvServiceImpl implements RdvService {
    
    @Autowired
    private RdvDao rdvDao;
    @Autowired
    private TechnicienDao technicienDao;
    @Autowired
    private AccountService accountService;
    
    @Override
    public Rdv createRdv(String adresseMail, String dateRdv, String commentaire) {
        UserAccount userAccount = accountService.loadUserByAdresseMail(adresseMail);
        Rdv rdv = new Rdv();
        if (userAccount == null) {
            throw new RuntimeException("user non trouver");
        }
        rdv.setCommantaire(commentaire);
        rdv.setDateRdv(dateRdv);
        rdv.setUserAccount(userAccount);
        rdvDao.save(rdv);
        return rdv;
    }
    
    @Override
    public Rdv findByDateRdv(String dateRdv) {
        return rdvDao.findByDateRdv(dateRdv);
    }
    
    @Override
    public Rdv findByTechnicien(Technicien technicien) {
        return rdvDao.findByTechnicien(technicien);
    }
    
    @Override
    public Rdv findByLogTech(String logTech) {
        if (logTech.equals("")) {
            throw new RuntimeException("log tech est vide");
        }
        Technicien technicien = technicienDao.findByloginTech(logTech);
        if (technicien == null) {
            throw new RuntimeException("technicien non trouvé");
        }
        Rdv rdv = findByTechnicien(technicien);
        if (rdv == null) {
            throw new RuntimeException("rdv non trouvé");
        }
        return rdv;
    }
    
}
