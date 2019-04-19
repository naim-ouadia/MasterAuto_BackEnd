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
public class ClientVo {

    private Long id;
    private String nom;
    private String prenom;
    private String adresseMail;
    private String adressePostale;
    private String numTel;
    private String pwd;
    private String pwdConfirmation;
    private List<VoitureVo> voituresVos;
    private RdvVo rdvVo;

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

    public String getAdressePostale() {
        return adressePostale;
    }

    public void setAdressePostale(String adressePostale) {
        this.adressePostale = adressePostale;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
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

    public List<VoitureVo> getVoituresVos() {
        return voituresVos;
    }

    public void setVoituresVos(List<VoitureVo> voituresVos) {
        this.voituresVos = voituresVos;
    }

    public RdvVo getRdvVo() {
        return rdvVo;
    }

    public void setRdvVo(RdvVo rdvVo) {
        this.rdvVo = rdvVo;
    }

}
