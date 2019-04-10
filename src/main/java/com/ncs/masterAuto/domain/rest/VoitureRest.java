/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.rest;

import com.ncs.masterAuto.domain.bean.CategorieVoiture;
import com.ncs.masterAuto.domain.bean.Client;
import com.ncs.masterAuto.domain.bean.MarqueVoiture;
import com.ncs.masterAuto.domain.bean.ModelVoiture;
import com.ncs.masterAuto.domain.bean.TypeCarburantVoiture;
import com.ncs.masterAuto.domain.bean.Voiture;
import com.ncs.masterAuto.domain.model.Service.VoitureService;
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
@RequestMapping("/master_Auto/voitures")
public class VoitureRest {

    @Autowired
   private  VoitureService voitureService;

    //******* getters et setters *******//
    public VoitureService getVoitureService() {
        return voitureService;
    }

    public void setVoitureService(VoitureService voitureService) {
        this.voitureService = voitureService;
    }
//*************************************************************//

    @PostMapping("/")
    public int createVoiture(@RequestBody Voiture voiture) {
        return voitureService.createVoiture(voiture);
    }

//    @PostMapping("/marques")
//    public Voiture findByMarque(@RequestBody MarqueVoiture marque) {
//        return voitureService.findByMarque(marque);
//    }
//
//    @GetMapping
//    public Voiture findByModel(@PathVariable ModelVoiture model) {
//        return voitureService.findByModel(model);
//    }
//
//    @GetMapping
//    public Voiture findByCategorie(@PathVariable CategorieVoiture categorie) {
//        return voitureService.findByCategorie(categorie);
//    }
//
//    @GetMapping
//    public Voiture findByTypeCarburant(@PathVariable TypeCarburantVoiture typeCarburant) {
//        return voitureService.findByTypeCarburant(typeCarburant);
//    }
//
//    @GetMapping
//    public List<Voiture> findByClient(@PathVariable Client client) {
//        return voitureService.findByClient(client);
//    }

}
