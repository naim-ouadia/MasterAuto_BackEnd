/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.model.Service.Impl;

import com.ncs.masterAuto.domain.bean.Rdv;
import com.ncs.masterAuto.domain.bean.Technicien;
import com.ncs.masterAuto.domain.model.Service.RdvService;
import com.ncs.masterAuto.domain.model.dao.RdvDao;
import com.ncs.masterAuto.domain.model.dao.TechnicienDao;
import java.util.Date;
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

    @Override
    public Rdv createRdv(Rdv rdv) {
        if (rdv == null) {
            throw new RuntimeException("Rdv est null");
        }
        Rdv r = findByDateRdv(rdv.getDateRdv());
        if (r != null) {
            throw new RuntimeException("rdv déja existant ");
        }

//        if (rdv.getTechnicien() == null) {
//            throw new RuntimeException("technicien du rdv est null");
//        }
//        if (rdv.getUserAccount() == null) {
//            throw new RuntimeException("user du rdv est null");
//        }
        rdvDao.save(rdv);
        return rdv;
    }

    @Override
    public Rdv findByDateRdv(Date dateRdv) {
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
