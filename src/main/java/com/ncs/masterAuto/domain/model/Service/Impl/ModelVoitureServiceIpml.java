/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.model.Service.Impl;

import com.ncs.masterAuto.domain.bean.ModelVoiture;
import com.ncs.masterAuto.domain.model.Service.ModelVoitureService;
import com.ncs.masterAuto.domain.model.dao.ModelVoitureDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author wadie
 */
@Service
@Transactional
public class ModelVoitureServiceIpml implements ModelVoitureService {

    @Autowired
    private ModelVoitureDao modelVoituredao;

    public ModelVoitureDao getModelVoituredao() {
        return modelVoituredao;
    }

    public void setModelVoituredao(ModelVoitureDao modelVoituredao) {
        this.modelVoituredao = modelVoituredao;
    }

//*******************************************************//
    @Override
    public ModelVoiture findByNomModel(String nomModel) {
        return modelVoituredao.findByNomModel(nomModel);
    }

    @Override
    public int createModel(ModelVoiture modelVoiture) {
        ModelVoiture model = findByNomModel(modelVoiture.getNomModel());
        if (model != null) {
            return -1;
        } else {
            modelVoituredao.save(modelVoiture);
            return 1;
        }
    }

}
