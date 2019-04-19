/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domaine.rest.vo;

import java.util.List;

/**
 *
 * @author wadie
 */
public class TechnicienVo {

    private Long id;
    private String login;
    private String nom;
    private String prenom;
    private String numTel;
    private List<RdvVo> rdvsVos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public List<RdvVo> getRdvsVos() {
        return rdvsVos;
    }

    public void setRdvsVos(List<RdvVo> rdvsVos) {
        this.rdvsVos = rdvsVos;
    }

}
