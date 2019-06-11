/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.rest;

import com.ncs.masterAuto.domain.bean.Ath;
import com.ncs.masterAuto.domain.model.Service.AthService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wadie
 */
@RestController
@RequestMapping("/master_Auto/Ath")
public class AthRest {

    @Autowired
    private AthService athService;

    @PostMapping("/newAth")
    public int addNewAth(@RequestBody Ath ath) {
        return athService.addNewAth(ath);
    }

    @GetMapping("/findAllAth")
    public List<Ath> findAll() {
        return athService.findAll();
    }

    @GetMapping("/findById/{id}")
    public Ath findById(@PathVariable Long id) {
        return athService.findById(id);
    }

    @PutMapping("/updateAth/id/{id}")
    public Ath updateAth(@PathVariable Long id, @RequestBody Ath ath) {
        return athService.updateAth(id, ath);
    }

    @DeleteMapping("/deleteAth/{id}")
    public void deletAth(@PathVariable Long id) {
        athService.deletAth(id);
    }

}
