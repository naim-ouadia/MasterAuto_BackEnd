/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.model.Service.Impl;

import com.ncs.masterAuto.domain.bean.Ath;
import com.ncs.masterAuto.domain.model.Service.AthService;
import com.ncs.masterAuto.domain.model.dao.AthDao;
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
public class AthServiceImpl implements AthService {
    
    @Autowired
    private AthDao athDao;
    
    @Override
    public int addNewAth(Ath ath) {
        Ath ath1 = athDao.findByNomAth(ath.getNomAth());
        if (ath == null) {
            return -1;
        } else if (ath1 != null) {
            return -2;
        } else {
            athDao.save(ath);
            return 1;
        }
    }
    
    @Override
    public List<Ath> findAll() {
        return athDao.findAll();
    }
    
    @Override
    public Ath findById(Long id) {
        return athDao.findById(id).get();
    }
    
    @Override
    public Ath updateAth(Long id, Ath ath) {
        Ath ath1 = athDao.findById(id).get();
        if (ath1 == null) {
            return null;
        } else {
            ath.setId(id);
            athDao.save(ath);
            return ath;
        }
    }
    
    @Override
    public void deletAth(Long id) {
        athDao.deleteById(id);
    }
    
}
