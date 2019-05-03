/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package com.ncs.masterAuto.domaine.rest.converter;
//
//import com.ncs.masterAuto.domain.bean.Rdv;
//import com.ncs.masterAuto.domaine.rest.vo.RdvVo;
//import org.springframework.stereotype.Component;
//
///**
// *
// * @author wadie
// */
//@Component
//public class RdvConverter extends AbstractConverter<Rdv, RdvVo> {
//
//    @Override
//    public Rdv toItem(RdvVo vo) {
//        if (vo == null) {
//            return null;
//        } else {
//            Rdv item = new Rdv();
//            item.setClient(new ClientConverter().toItem(vo.getClientVo()));
//            item.setDateRdv(vo.getDateRdv());
//            item.setTechnicien(new TechnicienConverter().toItem(vo.getTechnicienVo()));
//            return item;
//        }
//    }
//
//    @Override
//    public RdvVo toVO(Rdv t) {
//        if (t == null) {
//            return null;
//        } else {
//            RdvVo vo = new RdvVo();
//            vo.setClientVo(new ClientConverter().toVO(t.getClient()));
//            vo.setDateRdv(t.getDateRdv());
//            vo.setTechnicienVo(new TechnicienConverter().toVO(t.getTechnicien()));
//            return vo;
//        }
//    }
//
//}
