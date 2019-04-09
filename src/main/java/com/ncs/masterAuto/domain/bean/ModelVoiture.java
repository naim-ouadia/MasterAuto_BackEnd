 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author wadie
 */
@Entity
public class ModelVoiture implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //*****Attributs******//
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateModel;
    private String nomModel;

    @OneToMany(mappedBy = "model")
    private List<Voiture> voitures;
//******constructeurs ****//

    public ModelVoiture() {
    }

    public ModelVoiture(Date dateModel, String nomModel, List<Voiture> voitures) {
        this.dateModel = dateModel;
        this.nomModel = nomModel;
        this.voitures = voitures;
    }

    //****** getters et setters ****//
    public Date getDateModel() {
        return dateModel;
    }

    public void setDateModel(Date dateModel) {
        this.dateModel = dateModel;
    }

    public String getNomModel() {
        return nomModel;
    }

    public void setNomModel(String nomModel) {
        this.nomModel = nomModel;
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
        if (!(object instanceof ModelVoiture)) {
            return false;
        }
        ModelVoiture other = (ModelVoiture) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ncs.masterAuto.domain.bean.ModelVoiture[ id=" + id + " ]";
    }

}
