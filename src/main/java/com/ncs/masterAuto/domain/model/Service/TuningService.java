/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.model.Service;

import com.ncs.masterAuto.domain.bean.Tuning;
import java.util.List;

/**
 *
 * @author wadie
 */
public interface TuningService {

    public Tuning saveTuning(Tuning tuning);

    public int deleteTuning(Long id);

    public List<Tuning> findAllTuning();

    public Tuning findById(Long id);

    public Tuning updateTuning(Tuning tuning, Long id);
}
