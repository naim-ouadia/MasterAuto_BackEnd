/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.model.Service.Impl;

import com.ncs.masterAuto.domain.bean.CategorieVoiture;
import com.ncs.masterAuto.domain.model.Service.CategorieVoitureService;
import com.ncs.masterAuto.domain.model.Service.VoitureService;
import com.ncs.masterAuto.domain.model.dao.CategorieVoitureDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author wadie
 */
@Service
@Transactional
public class CategorieVoitureServiceImpl implements CategorieVoitureService {

    @Autowired
    private CategorieVoitureDao categorieVoitureDao;
    @Autowired
    private VoitureService voitureService;

    //***** getters et setters ******//
    public CategorieVoitureDao getCategorieVoituredao() {
        return categorieVoitureDao;
    }

    public void setCategorieVoituredao(CategorieVoitureDao categorieVoituredao) {
        this.categorieVoitureDao = categorieVoituredao;
    }
//******************************************************************//

    @Override
    public CategorieVoiture findByNomCategorie(String nomCategorie) {
        return categorieVoitureDao.findByNomCategorie(nomCategorie);
    }

    @Override
    public int createCategorie(CategorieVoiture categorie) {
        voitureService.createVoiture(categorie, categorie.getVoitures());
        categorieVoitureDao.save(categorie);
        return 1;
    }

    @Override
    public List<CategorieVoiture> findAllCategorie() {
        return categorieVoitureDao.findAll();
    }

}
