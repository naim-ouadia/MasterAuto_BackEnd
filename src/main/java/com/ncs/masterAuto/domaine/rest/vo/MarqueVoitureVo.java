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
public class MarqueVoitureVo {

    private Long id;
    private String nomMarque;
    private List<VoitureVo> voituresVos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomMarque() {
        return nomMarque;
    }

    public void setNomMarque(String nomMarque) {
        this.nomMarque = nomMarque;
    }

    public List<VoitureVo> getVoituresVos() {
        return voituresVos;
    }

    public void setVoituresVos(List<VoitureVo> voituresVos) {
        this.voituresVos = voituresVos;
    }

}
