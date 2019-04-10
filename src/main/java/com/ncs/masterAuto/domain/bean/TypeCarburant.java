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
import javax.persistence.OneToOne;

/**
 *
 * @author wadie
 */
@Entity
public class TypeCarburant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    //*****Attributs******//
    private Long id;
    private String nomCarburant;
    @OneToOne(mappedBy = "typeCarburant")
    private Voiture voiture;

    //*****getters et setters **********//
    public String getNomCarburant() {
        return nomCarburant;
    }

    public void setNomCarburant(String nomCarburant) {
        this.nomCarburant = nomCarburant;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
//*********** constructeurs **********//

    public TypeCarburant() {
    }

    public TypeCarburant(String nomCarburant, Voiture voiture) {
        this.nomCarburant = nomCarburant;
        this.voiture = voiture;
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
        if (!(object instanceof TypeCarburant)) {
            return false;
        }
        TypeCarburant other = (TypeCarburant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ncs.masterAuto.domain.bean.TypeCarburantVoiture[ id=" + id + " ]";
    }

}
