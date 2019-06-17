/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.model.Service;

import com.ncs.masterAuto.domain.bean.Technicien;
import com.ncs.masterAuto.domain.bean.UserAccount;
import java.util.List;

/**
 *
 * @author wadie
 */
public interface TechnicienService {

    public Technicien createTechnicien(UserAccount userAccount);

    public Technicien findByLogin(String login);

    public Technicien findByNom(String nom);

    public List<Technicien> findAll();
    
    public Technicien techForRdv();
    
    public Technicien findById(long id);
    
}
