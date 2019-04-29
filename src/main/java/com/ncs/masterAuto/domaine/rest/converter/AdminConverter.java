///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.ncs.masterAuto.domaine.rest.converter;
//
//import com.ncs.masterAuto.domain.bean.User;
//import com.ncs.masterAuto.domaine.rest.vo.AdminVo;
//import org.springframework.stereotype.Component;
//
///**
// *
// * @author wadie
// */
//@Component
//public class AdminConverter extends AbstractConverter<User, AdminVo> {
//
//    @Override
//    public User toItem(AdminVo vo) {
//        if (vo == null) {
//            return null;
//        } else {
//            User item = new User();
//            item.setNom(vo.getNom());
//            item.setPrenom(vo.getPrenom());
//            item.setAdresseMail(vo.getAdresseMail());
//            item.setPwd(vo.getPwd());
//            item.setPwdConfirmation(vo.getPwdConfirmation());
//            return item;
//        }
//    }
//
//    @Override
//    public AdminVo toVO(User t) {
//        if (t == null) {
//            return null;
//        } else {
//            AdminVo vo = new AdminVo();
//            vo.setNom(t.getNom());
//            vo.setPrenom(t.getPrenom());
//            vo.setAdresseMail(t.getAdresseMail());
//            vo.setPwd(t.getPwd());
//            vo.setPwdConfirmation(t.getPwdConfirmation());
//            return vo;
//        }
//    }
//
//}
