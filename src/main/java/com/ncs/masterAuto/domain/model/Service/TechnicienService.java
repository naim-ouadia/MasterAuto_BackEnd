/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.model.Service;

import com.ncs.masterAuto.domain.bean.Technicien;

/**
 *
 * @author wadie
 */
public interface TechnicienService {

    public int createTechnicien(Technicien technicien);

    public Technicien loginTechnicien(String login, String pwd);

    public Technicien findByLogin(String login);

    public Technicien findByNom(String nom);
}
