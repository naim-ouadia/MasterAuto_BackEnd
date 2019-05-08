/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.model.Service.Impl;

import com.ncs.masterAuto.domain.bean.MarqueVoiture;
import com.ncs.masterAuto.domain.model.Service.MarqueVoitureService;
import com.ncs.masterAuto.domain.model.dao.MarqueVoitureDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author wadie
 */
@Service
@Transactional
public class MarqueVoitureServiceImpl implements MarqueVoitureService {

    @Autowired
    private MarqueVoitureDao marqueVoitureDao;

    public MarqueVoitureDao getMarqueVoitureDao() {
        return marqueVoitureDao;
    }

    public void setMarqueVoitureDao(MarqueVoitureDao marqueVoitureDao) {
        this.marqueVoitureDao = marqueVoitureDao;
    }
    //**************************************************//

    @Override
    public MarqueVoiture findByNomMarque(String nomMarque) {
        return marqueVoitureDao.findByNomMarque(nomMarque);
    }

    @Override
    public int createMarqueVoiture(MarqueVoiture marqueVoiture) {
        MarqueVoiture marque = findByNomMarque(marqueVoiture.getNomMarque());
        if (marque != null) {
            return -1;
        } else {
            marqueVoitureDao.save(marqueVoiture);
            return 1;
        }
    }

}
