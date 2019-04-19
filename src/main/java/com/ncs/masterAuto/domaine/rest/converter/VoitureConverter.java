/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domaine.rest.converter;

import com.ncs.masterAuto.domain.bean.Voiture;
import com.ncs.masterAuto.domaine.rest.vo.VoitureVo;
import org.springframework.stereotype.Component;

/**
 *
 * @author wadie
 */
@Component
public class VoitureConverter extends AbstractConverter<Voiture, VoitureVo> {

    @Override
    public Voiture toItem(VoitureVo vo) {
        if (vo == null) {
            return null;
        } else {
            Voiture item = new Voiture();
            item.setCategorie(new CategorieVoitureConverter().toItem(vo.getCategorieVo()));
            item.setClient(new ClientConverter().toItem(vo.getClientVo()));
            item.setMarque(new MarqueVoitureConverter().toItem(vo.getMarqueVo()));
            item.setModel(new ModelVoitureConverter().toItem(vo.getModelVo()));
            item.setTypeCarburant(new TypeCarburantConverter().toItem(vo.getTypeCarburantVo()));
            return item;
        }
    }

    @Override
    public VoitureVo toVO(Voiture t) {
        if (t == null) {
            return null;
        } else {
            VoitureVo vo = new VoitureVo();
            vo.setCategorieVo(new CategorieVoitureConverter().toVO(t.getCategorie()));
            vo.setClientVo(new ClientConverter().toVO(t.getClient()));
            vo.setMarqueVo(new MarqueVoitureConverter().toVO(t.getMarque()));
            vo.setModelVo(new ModelVoitureConverter().toVO(t.getModel()));
            vo.setTypeCarburantVo(new TypeCarburantConverter().toVO(t.getTypeCarburant()));
            return vo;
        }
    }

}
