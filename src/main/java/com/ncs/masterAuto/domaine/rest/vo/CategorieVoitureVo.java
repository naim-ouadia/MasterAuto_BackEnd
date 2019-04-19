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
public class CategorieVoitureVo {

    private Long id;
    private String nomCategorie;
    private List<VoitureVo> voituresVos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public List<VoitureVo> getVoituresVos() {
        return voituresVos;
    }

    public void setVoituresVos(List<VoitureVo> voituresVos) {
        this.voituresVos = voituresVos;
    }

}
