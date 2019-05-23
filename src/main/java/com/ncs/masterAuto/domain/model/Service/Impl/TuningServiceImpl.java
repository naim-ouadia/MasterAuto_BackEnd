/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.model.Service.Impl;

import com.ncs.masterAuto.domain.bean.Tuning;
import com.ncs.masterAuto.domain.model.Service.TuningService;
import com.ncs.masterAuto.domain.model.dao.TuningDao;
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
public class TuningServiceImpl implements TuningService {

    @Autowired
    private TuningDao tuningDao;

    @Override
    public Tuning saveTuning(Tuning tuning) {
        Tuning tuning1 = tuningDao.findByNomTuning(tuning.getNomTuning());
        if (tuning == null) {
            throw new RuntimeException("tuning est null");
        }
        if (tuning1 != null) {
            throw new RuntimeException("tuning est déja existant");
        }
        tuningDao.save(tuning);
        return tuning;
    }

    @Override
    public int deleteTuning(String nomTuning) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tuning> findAllTuning() {
        return tuningDao.findAll();
    }

}
