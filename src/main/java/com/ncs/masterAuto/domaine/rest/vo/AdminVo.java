/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domaine.rest.vo;

/**
 *
 * @author wadie
 */
public class AdminVo {

    private Long id;
    private String nom;
    private String prenom;
    private String adresseMail;
    private String pwd;
    private String pwdConfirmation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getAdresseMail() {
        return adresseMail;
    }

    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPwdConfirmation() {
        return pwdConfirmation;
    }

    public void setPwdConfirmation(String pwdConfirmation) {
        this.pwdConfirmation = pwdConfirmation;
    }

}
