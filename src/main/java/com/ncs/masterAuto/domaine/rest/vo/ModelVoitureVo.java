/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domaine.rest.vo;

import java.util.Date;
import java.util.List;

/**
 *
 * @author wadie
 */
public class ModelVoitureVo {

    private Long id;
    private Date dateModel;
    private String nomModel;
    private List<VoitureVo> voituresVos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<VoitureVo> getVoituresVos() {
        return voituresVos;
    }

    public void setVoituresVos(List<VoitureVo> voituresVos) {
        this.voituresVos = voituresVos;
    }

}
