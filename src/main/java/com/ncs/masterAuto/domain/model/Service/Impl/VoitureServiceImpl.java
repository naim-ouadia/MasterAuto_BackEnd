/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.model.Service.Impl;

import com.ncs.masterAuto.domain.bean.CategorieVoiture;
import com.ncs.masterAuto.domain.bean.MarqueVoiture;
import com.ncs.masterAuto.domain.bean.ModelVoiture;
import com.ncs.masterAuto.domain.bean.Rdv;
import com.ncs.masterAuto.domain.bean.TypeCarburant;
import com.ncs.masterAuto.domain.bean.Voiture;
import com.ncs.masterAuto.domain.model.Service.VoitureService;
import com.ncs.masterAuto.domain.model.dao.CategorieVoitureDao;
import com.ncs.masterAuto.domain.model.dao.MarqueVoitureDao;
import com.ncs.masterAuto.domain.model.dao.ModelVoitureDao;
import com.ncs.masterAuto.domain.model.dao.TypeCarburantDao;
import com.ncs.masterAuto.domain.model.dao.VoitureDao;
import java.util.ArrayList;
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
public class VoitureServiceImpl implements VoitureService {

    @Autowired
    private VoitureDao voitureDao;
    @Autowired
    private ModelVoitureDao modelVoitureDao;
    @Autowired
    private MarqueVoitureDao marqueVoitureDao;
    @Autowired
    private CategorieVoitureDao categorieVoitureDao;
    @Autowired
    private TypeCarburantDao typeCarburantDao;

    @Override
    public Voiture createVoiture(String marque, String model, String categorie, String caraburant) {
        Voiture voiture = new Voiture();
        MarqueVoiture marqueVoiture = marqueVoitureDao.findByNomMarque(marque);
        ModelVoiture modelVoiture = modelVoitureDao.findByNomModel(model);
        CategorieVoiture categorieVoiture = categorieVoitureDao.findByNomCategorie(categorie);
        TypeCarburant typeCarburant = typeCarburantDao.findByNomCarburant(caraburant);
        voiture.setMarque(marqueVoiture);
        voiture.setCategorie(categorieVoiture);
        voiture.setModel(modelVoiture);
        voiture.setTypeCarburant(typeCarburant);
        voitureDao.save(voiture);
        return voiture;

    }

    @Override
    public List<Voiture> findByRdv(List<Rdv> rdvs) {
        List<Voiture> voitures = new ArrayList<>();
        Voiture voiture = new Voiture();
        for (Rdv rdv : rdvs) {
            voiture = voitureDao.findById(rdv.getVoiture().getId()).get();
            voitures.add(voiture);
        }
        return voitures;
    }

}
