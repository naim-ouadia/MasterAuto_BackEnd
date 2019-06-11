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
    public int addNewFichierTechnique(FichierTechnique fichierTechnique) {
        FichierTechnique fichierTechnique1 = fichierTechniqueDao.findBynomFichier(fichierTechnique.getNomFichier());
        if (fichierTechnique == null) {
            return -1;
        } else if (fichierTechnique1 != null) {
            return -2;
        } else {
            fichierTechnique.setFichierTechnique("default");
            fichierTechniqueDao.save(fichierTechnique);
            return 1;
        }
    }

    @Override
    public List<FichierTechnique> findAllFichierTechnique() {
        return fichierTechniqueDao.findAll();
    }

    @Override
    public FichierTechnique findById(Long id) {
        return fichierTechniqueDao.findById(id).get();
    }

    @Override
    public int deleteFichier(Long id) {
        FichierTechnique fichierTechnique = fichierTechniqueDao.findById(id).get();
        if (fichierTechnique == null) {
            return -1;
        } else {
            fichierTechniqueDao.deleteById(id);
            return 1;
        }

    }

}
