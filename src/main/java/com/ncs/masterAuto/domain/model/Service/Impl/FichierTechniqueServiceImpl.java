/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.model.Service.Impl;

import com.ncs.masterAuto.domain.bean.FichierTechnique;
import com.ncs.masterAuto.domain.model.dao.FichierTechniqueDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ncs.masterAuto.domain.model.Service.FichierTechniqueService;

/**
 *
 * @author wadie
 */
@Service
@Transactional
public class FichierTechniqueServiceImpl implements FichierTechniqueService {

    @Autowired
    private FichierTechniqueDao fichierTechniqueDao;

    @Override
    public FichierTechnique addNewFichierTechnique(FichierTechnique fichierTechnique) {
        FichierTechnique fichierTechnique1 = fichierTechniqueDao.findBynomFichier(fichierTechnique.getNomFichier());
        if (fichierTechnique == null) {
            return null;
        } else if (fichierTechnique1 != null) {
            return null;
        } else {
            fichierTechnique.setFichierTechnique("default");
            fichierTechniqueDao.save(fichierTechnique);
            return fichierTechnique;
        }
    }

    @Override
    public List<FichierTechnique> findAllFichierTechnique() {
        return fichierTechniqueDao.findAll();
    }

    @Override
    public FichierTechnique findById(long id) {
        return fichierTechniqueDao.findById(id).get();
    }

    @Override
    public void deleteFichier(Long id) {
        fichierTechniqueDao.deleteById(id);
    }

    @Override
    public FichierTechnique upDateFichier(long id, FichierTechnique fichierTechnique) {
        FichierTechnique fichierTechnique1 = fichierTechniqueDao.findById(id).get();
        if (fichierTechnique1 == null) {
            return null;
        } else {
            fichierTechnique.setId(id);
            fichierTechniqueDao.save(fichierTechnique);
            return fichierTechnique;
        }
    }

}
