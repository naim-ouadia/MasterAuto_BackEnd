/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.rest;

import com.ncs.masterAuto.domain.bean.Client;
import com.ncs.masterAuto.domain.bean.Rdv;
import com.ncs.masterAuto.domain.bean.Technicien;
import com.ncs.masterAuto.domain.model.Service.RdvService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/AdresseMail/{AdresseMail}/loginTech/{loginTech}")
    public int createRdv(@RequestBody Rdv rdv, @PathVariable String AdresseMail, @PathVariable String loginTech) {
        return rdvService.createRdv(rdv, AdresseMail, loginTech);
    }

    @PostMapping("/client")
    public Rdv findByClient(@RequestBody Client client) {
        return rdvService.findByClient(client);
    }

    @PostMapping("/Technicien")
    public Rdv findByTechnicien(@RequestBody Technicien technicien) {
        return rdvService.findByTechnicien(technicien);
    }

    @PostMapping("/DateRdv")
    public Rdv findByDateRdv(@RequestBody Date dateRdv) {
        return rdvService.findByDateRdv(dateRdv);
    }
}
