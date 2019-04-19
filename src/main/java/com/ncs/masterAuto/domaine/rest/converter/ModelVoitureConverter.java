/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domaine.rest.converter;

import com.ncs.masterAuto.domain.bean.ModelVoiture;
import com.ncs.masterAuto.domaine.rest.vo.ModelVoitureVo;
import org.springframework.stereotype.Component;

/**
 *
 * @author wadie
 */
@Component
public class ModelVoitureConverter extends AbstractConverter<ModelVoiture, ModelVoitureVo> {

    @Override
    public ModelVoiture toItem(ModelVoitureVo vo) {
        if (vo == null) {
            return null;
        } else {
            ModelVoiture item = new ModelVoiture();
            item.setDateModel(vo.getDateModel());
            item.setNomModel(vo.getNomModel());
            item.setVoitures(new VoitureConverter().toItem(vo.getVoituresVos()));
            return item;
        }
    }

    @Override
    public ModelVoitureVo toVO(ModelVoiture t) {
        if (t == null) {
            return null;
        } else {
            ModelVoitureVo vo = new ModelVoitureVo();
            vo.setDateModel(t.getDateModel());
            vo.setNomModel(t.getNomModel());
            vo.setVoituresVos(new VoitureConverter().toVo(t.getVoitures()));
            return vo;
        }
    }

}
