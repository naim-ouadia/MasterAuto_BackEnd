/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domaine.rest.converter;

import com.ncs.masterAuto.domain.bean.MarqueVoiture;
import com.ncs.masterAuto.domaine.rest.vo.MarqueVoitureVo;
import org.springframework.stereotype.Component;

/**
 *
 * @author wadie
 */
@Component
public class MarqueVoitureConverter extends AbstractConverter<MarqueVoiture, MarqueVoitureVo> {

    @Override
    public MarqueVoiture toItem(MarqueVoitureVo vo) {
        if (vo == null) {
            return null;
        } else {
            MarqueVoiture item = new MarqueVoiture();
            item.setNomMarque(vo.getNomMarque());
            item.setVoitures(new VoitureConverter().toItem(vo.getVoituresVos()));
            return item;
        }
    }

    @Override
    public MarqueVoitureVo toVO(MarqueVoiture t) {
        if (t == null) {
            return null;
        } else {
            MarqueVoitureVo vo = new MarqueVoitureVo();
            vo.setNomMarque(t.getNomMarque());
            vo.setVoituresVos(new VoitureConverter().toVo(t.getVoitures()));
            return vo;
        }
    }

}
