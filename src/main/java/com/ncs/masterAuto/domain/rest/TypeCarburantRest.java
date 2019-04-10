/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.rest;

import com.ncs.masterAuto.domain.bean.TypeCarburant;
import com.ncs.masterAuto.domain.model.Service.TypeCarburantService;
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
@RequestMapping("/master_Auto/typeCarburant")
public class TypeCarburantRest {

    @Autowired
    private TypeCarburantService TypeCarburantService;

    public TypeCarburantService getTypeCarburantService() {
        return TypeCarburantService;
    }

    public void setTypeCarburantService(TypeCarburantService TypeCarburantService) {
        this.TypeCarburantService = TypeCarburantService;
    }
    //*******************************************************//

    @GetMapping("/nomCarburant/{nomCarburant}")
    public TypeCarburant findByNomCarburant(@PathVariable String nomCarburant) {
        return TypeCarburantService.findByNomCarburant(nomCarburant);
    }

    @PostMapping("/")
    public int createTypeCarburant(@RequestBody TypeCarburant typeCarburant) {
        return TypeCarburantService.createTypeCarburant(typeCarburant);
    }

}
