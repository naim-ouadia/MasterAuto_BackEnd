/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.bean;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author wadie
 */
@Entity
public class Technicien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //*****Attributs******//
    private Long id;
    private String login;
    private String nom;
    private String prenom;
    private Double numTel;
    @OneToMany(mappedBy = "technicien")
    private List<Rdv> rdvs;

    //******constructeurs *****//
    public Technicien() {
    }

    public Technicien(String login, String nom, String prenom, Double numTel, List<Rdv> rdvs) {
        this.login = login;
        this.nom = nom;
        this.prenom = prenom;
        this.numTel = numTel;
        this.rdvs = rdvs;
    }

    //*****getters et setters *******//
    public List<Rdv> getRdvs() {
        return rdvs;
    }

    public void setRdvs(List<Rdv> rdvs) {
        this.rdvs = rdvs;
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

    public Double getNumTel() {
        return numTel;
    }

    public void setNumTel(Double numTel) {
        this.numTel = numTel;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Technicien)) {
            return false;
        }
        Technicien other = (Technicien) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Technicien{" + "id=" + id + ", login=" + login + ", nom=" + nom + ", prenom=" + prenom + ", numTel=" + numTel + ", rdvs=" + rdvs + '}';
    }

}
