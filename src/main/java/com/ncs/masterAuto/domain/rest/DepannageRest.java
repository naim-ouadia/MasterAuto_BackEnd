/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.rest;

import com.ncs.masterAuto.domain.bean.Depannage;
import com.ncs.masterAuto.domain.model.Service.DepannageService;
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
@RequestMapping("/master_Auto/depannage")
public class DepannageRest {

    @Autowired
    private DepannageService depannageService;

    @PostMapping("/addNewDepannage")
    public int addNewDepannage(@RequestBody Depannage depannage) {
        return depannageService.addNewDepannage(depannage);
    }

    @GetMapping("/findAllDepannage")
    public List<Depannage> findAllDepannage() {
        return depannageService.findAllDepannage();
    }

    @GetMapping("/findById/{id}")
    public Depannage findById(@PathVariable Long id) {
        return depannageService.findById(id);
    }

}
