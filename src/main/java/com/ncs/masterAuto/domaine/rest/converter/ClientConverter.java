/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domaine.rest.converter;

import com.ncs.masterAuto.commun.NumberUtil;
import com.ncs.masterAuto.domain.bean.Client;
import com.ncs.masterAuto.domaine.rest.vo.ClientVo;
import org.springframework.stereotype.Component;

/**
 *
 * @author wadie
 */
@Component  
public class ClientConverter extends AbstractConverter<Client, ClientVo> {
    
    @Override
    public Client toItem(ClientVo vo) {
        if (vo == null) {
            return null;
        } else {
            Client item = new Client();
            item.setNom(vo.getNom());
            item.setPrenom(vo.getPrenom());
            item.setNumTel(NumberUtil.toDouble(vo.getNumTel()));
            item.setAdresseMail(vo.getAdresseMail());
            item.setAdressePostale(vo.getAdressePostale());
            item.setPwd(vo.getPwd());
            item.setPwdConfirmation(vo.getPwdConfirmation());
            item.setRdv(new RdvConverter().toItem(vo.getRdvVo()));
            item.setVoitures(new VoitureConverter().toItem(vo.getVoituresVos()));
            return item;
        }
    }
    
    @Override
    public ClientVo toVO(Client t) {
        if (t == null) {
            return null;
        } else {
            ClientVo vo = new ClientVo();
            vo.setNom(t.getNom());
            vo.setPrenom(t.getPrenom());
            vo.setNumTel(NumberUtil.toString(t.getNumTel()));
            vo.setAdresseMail(t.getAdresseMail());
            vo.setAdressePostale(t.getAdressePostale());
            vo.setPwd(t.getPwd());
            vo.setPwdConfirmation(t.getPwdConfirmation());
            vo.setRdvVo(new RdvConverter().toVO(t.getRdv()));
            vo.setVoituresVos(new VoitureConverter().toVo(t.getVoitures()));
            return vo;
        }
    }
    
}
