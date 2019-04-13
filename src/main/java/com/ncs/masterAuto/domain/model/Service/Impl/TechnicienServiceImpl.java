/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.model.Service.Impl;

import com.ncs.masterAuto.domain.bean.Technicien;
import com.ncs.masterAuto.domain.model.Service.RdvService;
import com.ncs.masterAuto.domain.model.Service.TechnicienService;
import com.ncs.masterAuto.domain.model.dao.TechnicienDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author wadie
 */
@Service
public class TechnicienServiceImpl implements TechnicienService {

    @Autowired
    private TechnicienDao technicienDao;
    @Autowired
    private RdvService rdvService;

    public RdvService getRdvService() {
        return rdvService;
    }

    public void setRdvService(RdvService rdvService) {
        this.rdvService = rdvService;
    }

    public TechnicienDao getTechnicienDao() {
        return technicienDao;
    }

    public void setTechnicienDao(TechnicienDao technicienDao) {
        this.technicienDao = technicienDao;
    }
//****************************************************//

    @Override
    public int createTechnicien(Technicien technicien) {
        Technicien t = findByLogin(technicien.getLogin());
        if (technicien == null) {
            return -1;
        } else if (t != null) {
            return -2;
        } else {
            technicienDao.save(technicien);
            return 1;
        }
    }

    @Override
    public Technicien findByLogin(String login) {
        return technicienDao.findByLogin(login);
    }

    @Override
    public Technicien findByNom(String nom) {
        return technicienDao.findByNom(nom);
    }

}
