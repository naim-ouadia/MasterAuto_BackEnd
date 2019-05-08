/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.rest;

import com.ncs.masterAuto.domain.bean.Tuning;
import com.ncs.masterAuto.domain.model.Service.TuningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wadie
 */
@RestController
@RequestMapping("/master_Auto/Tuning")
public class TuningRest {

    @Autowired
    private TuningService tuningService;

    @PostMapping("/creatTuning")
    public Tuning saveTuning(@RequestBody Tuning tuning) {
        return tuningService.saveTuning(tuning);
    }

    public int deleteTuning(String nomTuning) {
        return tuningService.deleteTuning(nomTuning);
    }

}
