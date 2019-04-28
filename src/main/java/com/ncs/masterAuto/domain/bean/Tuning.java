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
public class Tuning implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(mappedBy = "tuning")
    private List<CategorieTuning> categorieTunings;

    public Tuning() {
    }

    public Tuning(List<CategorieTuning> categorieTunings) {
        this.categorieTunings = categorieTunings;
    }

    public List<CategorieTuning> getCategorieTunings() {
        return categorieTunings;
    }

    public void setCategorieTunings(List<CategorieTuning> categorieTunings) {
        this.categorieTunings = categorieTunings;
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
        if (!(object instanceof Tuning)) {
            return false;
        }
        Tuning other = (Tuning) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ncs.masterAuto.domain.bean.Tuning[ id=" + id + " ]";
    }

}
