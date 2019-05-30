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
        tuning.setImage("84jpg");
        tuningDao.save(tuning);
        return tuning;
    }

    @Override
    public int deleteTuning(Long id) {
        Tuning tuning = tuningDao.findById(id).get();
        if (tuning == null) {
            return -1;
        } else {
            tuningDao.delete(tuning);
            return 1;
        }
    }

    @Override
    public List<Tuning> findAllTuning() {
        return tuningDao.findAll();
    }

    @Override
    public Tuning findById(Long id) {
        return tuningDao.findById(id).get();
    }

    @Override
    public Tuning updateTuning(Tuning tuning, Long id) {
        Tuning tuning1 = tuningDao.findById(id).get();
        if (tuning1 == null) {
            return null;
        } else {
            tuning.setId(id);
            tuning.setImage(tuning1.getImage());
            tuningDao.save(tuning);
            return tuning;
        }

    }

}
