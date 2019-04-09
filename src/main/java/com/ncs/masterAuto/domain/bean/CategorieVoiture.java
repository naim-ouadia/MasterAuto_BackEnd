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
public class CategorieVoiture implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //*****Attributs******//
    private Long id;
    private String nomCategorie;
    @OneToMany(mappedBy = "categorie")
    private List<Voiture> voitures;

    //**** constructeurs ****//
    public CategorieVoiture() {
    }

    public CategorieVoiture(String nomCategorie, List<Voiture> voitures) {
        this.nomCategorie = nomCategorie;
        this.voitures = voitures;
    }

    //***** getters et setters ****//
    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public List<Voiture> getVoitures() {
        return voitures;
    }

    public void setVoitures(List<Voiture> voitures) {
        this.voitures = voitures;
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
        if (!(object instanceof CategorieVoiture)) {
            return false;
        }
        CategorieVoiture other = (CategorieVoiture) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ncs.masterAuto.domain.bean.CategorieVoiture[ id=" + id + " ]";
    }

}
