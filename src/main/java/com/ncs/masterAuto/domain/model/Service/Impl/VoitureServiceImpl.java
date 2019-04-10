/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.model.Service.Impl;

import com.ncs.masterAuto.domain.bean.CategorieVoiture;
import com.ncs.masterAuto.domain.bean.Client;
import com.ncs.masterAuto.domain.bean.MarqueVoiture;
import com.ncs.masterAuto.domain.bean.ModelVoiture;
import com.ncs.masterAuto.domain.bean.TypeCarburantVoiture;
import com.ncs.masterAuto.domain.bean.Voiture;
import com.ncs.masterAuto.domain.model.Service.VoitureService;
import com.ncs.masterAuto.domain.model.dao.VoitureDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author wadie
 */
@Service
public class VoitureServiceImpl implements VoitureService {

    @Autowired
    private VoitureDao voitureDao;
//******getters et setters*****//

    public VoitureDao getVoitureDao() {
        return voitureDao;
    }

    public void setVoitureDao(VoitureDao voitureDao) {
        this.voitureDao = voitureDao;
    }
//*****************************************************

    @Override
    public Voiture findByMarque(MarqueVoiture marque) {
        return voitureDao.findByMarque(marque);
    }

    @Override
    public Voiture findByModel(ModelVoiture model) {
        return voitureDao.findByModel(model);
    }

    @Override
    public Voiture findByCategorie(CategorieVoiture categorie) {
        return voitureDao.findByCategorie(categorie);
    }

    @Override
    public Voiture findByTypeCarburant(TypeCarburantVoiture typeCarburant) {
        return voitureDao.findByTypeCarburant(typeCarburant);
    }

    @Override
    public List<Voiture> findByClient(Client client) {
        return voitureDao.findByClient(client);
    }

    @Override
    public int createVoiture(Voiture voiture) {

        Voiture v = voitureDao.findByMarque(voiture.getMarque());
        Voiture v2 = voitureDao.findByModel(voiture.getModel());
        Voiture v3 = voitureDao.findByTypeCarburant(v2.getTypeCarburant());
        if (voiture == null) {
            return -1;
        } else if (v3 != null) {
            return -2;
        } else {
            voitureDao.save(voiture);
            return 1;
        }
    }

}
