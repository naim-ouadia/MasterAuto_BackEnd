/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.rest;

import com.ncs.masterAuto.domain.bean.CategorieVoiture;
import com.ncs.masterAuto.domain.model.Service.CategorieVoitureService;
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
@RequestMapping("/master_Auto/categories")
public class CategorieVoitureRest {

    @Autowired
    private CategorieVoitureService categorieVoitureService;

    public CategorieVoitureService getCategorieVoitureService() {
        return categorieVoitureService;
    }

    public void setCategorieVoitureService(CategorieVoitureService categorieVoitureService) {
        this.categorieVoitureService = categorieVoitureService;
    }

    @GetMapping("/nomCategorie/{nomCategorie}")
    //*******************************************************************//
    public CategorieVoiture findByNomCategorie(@PathVariable String nomCategorie) {
        return categorieVoitureService.findByNomCategorie(nomCategorie);
    }

    @PostMapping("/")
    public int createCaategorie(@RequestBody CategorieVoiture categorieVoiture) {
        return categorieVoitureService.createCaategorie(categorieVoiture);
    }

}
