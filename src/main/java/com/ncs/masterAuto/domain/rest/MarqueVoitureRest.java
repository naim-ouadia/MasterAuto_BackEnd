/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.rest;

import com.ncs.masterAuto.domain.bean.MarqueVoiture;
import com.ncs.masterAuto.domain.model.Service.MarqueVoitureService;
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
@RequestMapping("/master_Auto/marques")
public class MarqueVoitureRest {

    @Autowired
    private MarqueVoitureService marqueVoitureService;

    public MarqueVoitureService getMarqueVoitureService() {
        return marqueVoitureService;
    }

    public void setMarqueVoitureService(MarqueVoitureService marqueVoitureService) {
        this.marqueVoitureService = marqueVoitureService;
    }
//**************************************************************//

    @GetMapping("/nomMarque/{nomMarque}")
    public MarqueVoiture findByNomMarque(@PathVariable String nomMarque) {
        return marqueVoitureService.findByNomMarque(nomMarque);
    }

    @PostMapping("/")
    public int createMarqueVoiture(@RequestBody MarqueVoiture marqueVoiture) {
        return marqueVoitureService.createMarqueVoiture(marqueVoiture);
    }

}
