/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domaine.rest.vo;

/**
 *
 * @author wadie
 */
public class TypeCarburantVo {

    private Long id;
    private String nomCarburant;
    private VoitureVo voitureVo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomCarburant() {
        return nomCarburant;
    }

    public void setNomCarburant(String nomCarburant) {
        this.nomCarburant = nomCarburant;
    }

    public VoitureVo getVoitureVo() {
        return voitureVo;
    }

    public void setVoitureVo(VoitureVo voitureVo) {
        this.voitureVo = voitureVo;
    }

}
