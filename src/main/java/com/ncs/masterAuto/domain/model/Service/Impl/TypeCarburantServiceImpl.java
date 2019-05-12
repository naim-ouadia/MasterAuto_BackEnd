/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.model.Service.Impl;

import com.ncs.masterAuto.domain.bean.TypeCarburant;
import com.ncs.masterAuto.domain.model.Service.TypeCarburantService;
import com.ncs.masterAuto.domain.model.dao.TypeCarburantDao;
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
public class TypeCarburantServiceImpl implements TypeCarburantService {

    @Autowired
    private TypeCarburantDao typeCarburantDao;

    @Override
    public TypeCarburant findByNomCarburant(String nomCarburant) {
        return typeCarburantDao.findByNomCarburant(nomCarburant);
    }

    @Override
    public int createTypeCarburant(TypeCarburant typeCarburant) {
        TypeCarburant typeC = findByNomCarburant(typeCarburant.getNomCarburant());
        if (typeCarburant == null) {
            return -1;
        } else if (typeC != null) {
            return -2;
        } else {
            typeCarburantDao.save(typeCarburant);
            return 1;
        }
    }

    @Override
    public List<TypeCarburant> findAllTypeCarburant() {
        return typeCarburantDao.findAll();
    }

}
