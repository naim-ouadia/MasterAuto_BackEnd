/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.model.Service.Impl;

import com.ncs.masterAuto.domain.bean.Depannage;
import com.ncs.masterAuto.domain.model.Service.DepannageService;
import com.ncs.masterAuto.domain.model.dao.DepannageDao;
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
public class DepannageServiceImpl implements DepannageService {
    
    @Autowired
    private DepannageDao depannageDao;
    
    @Override
    public int addNewDepannage(Depannage depannage) {
        Depannage depannage1 = depannageDao.findByNomDepannage(depannage.getNomDepannage());
        if (depannage == null) {
            return -1;
        } else if (depannage1 != null) {
            return -2;
        } else {
            depannageDao.save(depannage);
            return 1;
        }
    }
    
    @Override
    public List<Depannage> findAllDepannage() {
        return depannageDao.findAll();
    }
    
    @Override
    public Depannage findById(Long id) {
        return depannageDao.findById(id).get();
    }
    
    @Override
    public Depannage updateDepannage(Long id, Depannage depannage) {
        Depannage depannage1 = depannageDao.findById(id).get();
        if (depannage1 == null) {
            return null;
        } else {
            depannage.setId(id);
            depannageDao.save(depannage);
            return depannage;
        }
    }
    
    @Override
    public void deleteDepannage(Long id) {
        depannageDao.deleteById(id);
    }
    
}
