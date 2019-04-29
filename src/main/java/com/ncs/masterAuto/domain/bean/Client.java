/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author wadie
 */
@Entity
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //***********attributs*************//
    private Long id;
    private String nom;
    private String prenom;
    private String adresseMail;
    private String adressePostale;
    private Double numTel;
    private String pwd;
    private String pwdConfirmation;
    @OneToMany(mappedBy = "client")
    private List<Voiture> voitures;
    @OneToOne(mappedBy = "client")
    private Rdv rdv;
    

    //********getters et setters *************//
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

    public Double getNumTel() {
        return numTel;
    }

    public void setNumTel(Double numTel) {
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

    public List<Voiture> getVoitures() {
        return voitures;
    }

    public void setVoitures(List<Voiture> voitures) {
        this.voitures = voitures;
    }

    public Rdv getRdv() {
        return rdv;
    }

    public void setRdv(Rdv rdv) {
        this.rdv = rdv;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //*****constructeurs****//
    public Client() {
    }

    public Client(String nom, String prenom, String adresseMail, String adressePostale, Double numTel, String pwd, String pwdConfirmation, List<Voiture> voitures, Rdv rdv) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresseMail = adresseMail;
        this.adressePostale = adressePostale;
        this.numTel = numTel;
        this.pwd = pwd;
        this.pwdConfirmation = pwdConfirmation;
        this.voitures = voitures;
        this.rdv = rdv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ncs.masterAuto.domain.bean.Client[ id=" + id + " ]";
    }

}
