/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domaine.rest.converter;

import com.ncs.masterAuto.domain.bean.CategorieVoiture;
import com.ncs.masterAuto.domaine.rest.vo.CategorieVoitureVo;
import org.springframework.stereotype.Component;

/**
 *
 * @author wadie
 */
@Component
public class CategorieVoitureConverter extends AbstractConverter<CategorieVoiture, CategorieVoitureVo> {

    @Override
    public CategorieVoiture toItem(CategorieVoitureVo vo) {
        if (vo == null) {
            return null;
        } else {
            CategorieVoiture item = new CategorieVoiture();
            item.setNomCategorie(vo.getNomCategorie());
            item.setVoitures(new VoitureConverter().toItem(vo.getVoituresVos()));
            return item;
        }
    }

    @Override
    public CategorieVoitureVo toVO(CategorieVoiture t) {
        if (t == null) {
            return null;
        } else {
            CategorieVoitureVo vo = new CategorieVoitureVo();
            vo.setNomCategorie(t.getNomCategorie());
            vo.setVoituresVos(new VoitureConverter().toVo(t.getVoitures()));
            return vo;
        }
    }

}
