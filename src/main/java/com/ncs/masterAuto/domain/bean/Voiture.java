/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author wadie
 */
@Entity
public class Voiture implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    //***** attributs*****//
    private Long id;
    @ManyToOne
    private MarqueVoiture marque;
    @ManyToOne
    private ModelVoiture model;
    @ManyToOne
    private CategorieVoiture categorie;
    @OneToOne
    private TypeCarburant typeCarburant;

    //**** constructeurs ****//
    public Voiture() {
    }

//    public Voiture(MarqueVoiture marque, ModelVoiture model, CategorieVoiture categorie, TypeCarburant typeCarburant, Client client) {
//        this.marque = marque;
//        this.model = model;
//        this.categorie = categorie;
//        this.typeCarburant = typeCarburant;
//        this.client = client;
//    }

    //*****getters et setters *****//
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MarqueVoiture getMarque() {
        return marque;
    }

    public void setMarque(MarqueVoiture marque) {
        this.marque = marque;
    }

    public ModelVoiture getModel() {
        return model;
    }

    public void setModel(ModelVoiture model) {
        this.model = model;
    }

    public CategorieVoiture getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieVoiture categorie) {
        this.categorie = categorie;
    }

    public TypeCarburant getTypeCarburant() {
        return typeCarburant;
    }

    public void setTypeCarburant(TypeCarburant typeCarburant) {
        this.typeCarburant = typeCarburant;
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
        if (!(object instanceof Voiture)) {
            return false;
        }
        Voiture other = (Voiture) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ncs.masterAuto.domain.bean.Voiture[ id=" + id + " ]";
    }

}
