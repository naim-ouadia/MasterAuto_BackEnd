/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.rest;

import com.ncs.masterAuto.domain.bean.Rdv;
import com.ncs.masterAuto.domain.model.Service.RdvService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wadie
 */
@RestController
@RequestMapping("/master_Auto/Rdvs")
public class RdvRest {

    @Autowired
    private RdvService rdvService;

    @GetMapping("/adresseMail/{adresseMail}/dateRdv/{dateRdv}/commentaire/{commentaire}")
    public Rdv createRdv(@PathVariable String adresseMail, @PathVariable String dateRdv, @PathVariable String commentaire) {
        return rdvService.createRdv(adresseMail, dateRdv, commentaire);
    }

    @GetMapping("/logTech/{logTech}")
    public Rdv findByLogTech(@PathVariable String logTech) {
        return rdvService.findByLogTech(logTech);
    }

    @PostMapping("/dateRdv")
    public Rdv findByDateRdv(@RequestBody String dateRdv) {
        return rdvService.findByDateRdv(dateRdv);
    }

    @GetMapping("/listRdvsCient/{id}")
    public List<Rdv> findListRdvById(@PathVariable long id) {
        return rdvService.findListRdvById(id);
    }
}
