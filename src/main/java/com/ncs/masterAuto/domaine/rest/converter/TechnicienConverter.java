/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package com.ncs.masterAuto.domaine.rest.converter;
//
//import com.ncs.masterAuto.commun.NumberUtil;
//import com.ncs.masterAuto.domain.bean.Technicien;
//import com.ncs.masterAuto.domaine.rest.vo.TechnicienVo;
//import org.springframework.stereotype.Component;

/**
 *
 * @author wadie
 */
//@Component
//public class TechnicienConverter extends AbstractConverter<Technicien, TechnicienVo> {
//
//    @Override
//    public Technicien toItem(TechnicienVo vo) {
//        if (vo == null) {
//            return null;
//        } else {
//            Technicien item = new Technicien();
//            item.setLogin(vo.getLogin());
//            item.setNom(vo.getNom());
//            item.setPrenom(vo.getPrenom());
//            item.setNumTel(NumberUtil.toDouble(vo.getNumTel()));
//            item.setRdvs(new RdvConverter().toItem(vo.getRdvsVos()));
//            return item;
//        }
//    }
//
//    @Override
//    public TechnicienVo toVO(Technicien t) {
//        if (t == null) {
//            return null;
//        } else {
//            TechnicienVo vo = new TechnicienVo();
//            vo.setLogin(t.getLogin());
//            vo.setNom(t.getNom());
//            vo.setPrenom(t.getPrenom());
//            vo.setNumTel(NumberUtil.toString(t.getNumTel()));
//            vo.setRdvsVos(new RdvConverter().toVo(t.getRdvs()));
//            return vo;
//        }
//    }
//
//}
