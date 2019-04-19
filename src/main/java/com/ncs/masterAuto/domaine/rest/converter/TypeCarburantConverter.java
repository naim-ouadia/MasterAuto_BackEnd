/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domaine.rest.converter;

import com.ncs.masterAuto.domain.bean.TypeCarburant;
import com.ncs.masterAuto.domaine.rest.vo.TypeCarburantVo;
import org.springframework.stereotype.Component;

/**
 *
 * @author wadie
 */
@Component
public class TypeCarburantConverter extends AbstractConverter<TypeCarburant, TypeCarburantVo> {

    @Override
    public TypeCarburant toItem(TypeCarburantVo vo) {
        if (vo == null) {
            return null;
        } else {
            TypeCarburant item = new TypeCarburant();
            item.setNomCarburant(vo.getNomCarburant());
            item.setVoiture(new VoitureConverter().toItem(vo.getVoitureVo()));
            return item;
        }
    }

    @Override
    public TypeCarburantVo toVO(TypeCarburant t) {
        if (t == null) {
            return null;
        } else {
            TypeCarburantVo vo = new TypeCarburantVo();
            vo.setNomCarburant(t.getNomCarburant());
            vo.setVoitureVo(new VoitureConverter().toVO(t.getVoiture()));
            return vo;
        }
    }

}
