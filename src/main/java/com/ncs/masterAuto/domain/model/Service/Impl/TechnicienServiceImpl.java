/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.model.Service.Impl;

import com.ncs.masterAuto.domain.bean.Technicien;
import com.ncs.masterAuto.domain.bean.UserAccount;
import com.ncs.masterAuto.domain.model.Service.TechnicienService;
import com.ncs.masterAuto.domain.model.dao.TechnicienDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author wadie
 */
@Service
@Transactional
public class TechnicienServiceImpl implements TechnicienService {

    @Autowired
    private TechnicienDao technicienDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Technicien createTechnicien(UserAccount userAccount) {
        Technicien technicien = new Technicien();
        technicien.setLoginTech(userAccount.getAdresseMail());
        technicien.setNom(userAccount.getNom());
        technicien.setPrenom(userAccount.getPrenom());
        technicien.setNumTel(userAccount.getNumTel());
        technicien.setActived(true);
        technicien.setPassword(bCryptPasswordEncoder.encode(userAccount.getPassword()));
        technicien.setId(userAccount.getId());
        technicienDao.save(technicien);

        return technicien;
    }

    @Override
    public Technicien findByLogin(String login) {
        return technicienDao.findByloginTech(login);
    }

    @Override
    public Technicien findByNom(String nom) {
        return technicienDao.findByNom(nom);
    }

    @Override
    public List<Technicien> findAll() {
        return technicienDao.findAll();
    }

    @Override
    public Technicien techForRdv() {
        List<Technicien> techs = findAll();
        Technicien t = new Technicien();
        for (Technicien tech : techs) {
            if (tech.getRdvs().size() < 3) {
                t = tech;

            }
        }
        return t;

    }

}
