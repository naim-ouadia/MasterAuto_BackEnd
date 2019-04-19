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
public class VoitureVo {

    private Long id;
    private MarqueVoitureVo marqueVo;
    private ModelVoitureVo modelVo;
    private CategorieVoitureVo categorieVo;
    private TypeCarburantVo typeCarburantVo;
    private ClientVo clientVo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MarqueVoitureVo getMarqueVo() {
        return marqueVo;
    }

    public void setMarqueVo(MarqueVoitureVo marqueVo) {
        this.marqueVo = marqueVo;
    }

    public ModelVoitureVo getModelVo() {
        return modelVo;
    }

    public void setModelVo(ModelVoitureVo modelVo) {
        this.modelVo = modelVo;
    }

    public CategorieVoitureVo getCategorieVo() {
        return categorieVo;
    }

    public void setCategorieVo(CategorieVoitureVo categorieVo) {
        this.categorieVo = categorieVo;
    }

    public TypeCarburantVo getTypeCarburantVo() {
        return typeCarburantVo;
    }

    public void setTypeCarburantVo(TypeCarburantVo typeCarburantVo) {
        this.typeCarburantVo = typeCarburantVo;
    }

    public ClientVo getClientVo() {
        return clientVo;
    }

    public void setClientVo(ClientVo clientVo) {
        this.clientVo = clientVo;
    }

}
