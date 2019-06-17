/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.rest;

import com.ncs.masterAuto.domain.bean.Technicien;
import com.ncs.masterAuto.domain.model.Service.TechnicienService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wadie
 */
@RestController
@RequestMapping("/master_Auto/techniciens")
public class TechnicienRest {

    @Autowired
    private TechnicienService technicienService;

    @GetMapping("/login/{login}")
    public Technicien findByLogin(@PathVariable String login) {
        return technicienService.findByLogin(login);
    }

    @GetMapping("/nom/{nom}")
    public Technicien findByNom(@PathVariable String nom) {
        return technicienService.findByNom(nom);
    }

    @GetMapping("/findAllTechnicien")
    public List<Technicien> findAll() {
        return technicienService.findAll();
    }

    @GetMapping("/findById/{id}")
    public Technicien findById(@PathVariable long id) {
        return technicienService.findById(id);
    }

}
