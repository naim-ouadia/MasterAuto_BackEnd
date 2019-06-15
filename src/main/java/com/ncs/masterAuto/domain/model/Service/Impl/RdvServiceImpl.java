/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.model.Service.Impl;

import com.ncs.masterAuto.domain.bean.Rdv;
import com.ncs.masterAuto.domain.bean.Technicien;
import com.ncs.masterAuto.domain.bean.UserAccount;
import com.ncs.masterAuto.domain.bean.Voiture;
import com.ncs.masterAuto.domain.model.Service.AccountService;
import com.ncs.masterAuto.domain.model.Service.RdvService;
import com.ncs.masterAuto.domain.model.Service.TechnicienService;
import com.ncs.masterAuto.domain.model.dao.RdvDao;
import com.ncs.masterAuto.domain.model.dao.TechnicienDao;
import com.ncs.masterAuto.domain.model.dao.UserAccountDao;
import com.ncs.masterAuto.domain.model.dao.VoitureDao;
import java.util.List;
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
    private UserAccountDao userAccountDao;
    @Autowired
    private VoitureDao voitureDao;
    @Autowired
    private TechnicienService technicienService;

    @Override
    public Rdv createRdv(long idClient, long idVoiture, String dateRdv, String commentaire) {
        UserAccount userAccount = userAccountDao.findById(idClient).get();
        Voiture voiture = voitureDao.findById(idVoiture).get();
        Technicien technicien = technicienService.techForRdv();
        Rdv rdv = new Rdv();
        rdv.setCommantaire(commentaire);
        rdv.setDateRdv(dateRdv);
        rdv.setTechnicien(technicien);
        rdv.setUserAccount(userAccount);
        rdv.setVoiture(voiture);
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

    @Override
    public List<Rdv> findListRdvById(long id) {
        UserAccount userAccount = userAccountDao.findById(id).get();
        return rdvDao.findByUserAccount(userAccount);
    }

}
