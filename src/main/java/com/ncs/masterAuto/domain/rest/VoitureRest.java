/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.rest;

import com.ncs.masterAuto.domain.bean.Voiture;
import com.ncs.masterAuto.domain.model.Service.VoitureService;
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
@RequestMapping("/master_Auto/voitures")
public class VoitureRest {

    @Autowired
    private VoitureService voitureService;

    @GetMapping("/marque/{marque}/model/{model}/categorie/{categorie}/caraburant/{caraburant}")
    public Voiture createVoiture(@PathVariable String marque, @PathVariable String model, @PathVariable String categorie, @PathVariable String caraburant) {
        return voitureService.createVoiture(marque, model, categorie, caraburant);
    }

}
