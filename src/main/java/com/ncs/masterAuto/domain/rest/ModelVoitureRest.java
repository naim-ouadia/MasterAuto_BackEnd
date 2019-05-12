/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.rest;

import com.ncs.masterAuto.domain.bean.ModelVoiture;
import com.ncs.masterAuto.domain.model.Service.ModelVoitureService;
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
@RequestMapping("/master_Auto/models")
public class ModelVoitureRest {

    @Autowired
    private ModelVoitureService modelVoitureService;

    @GetMapping("/AllModel")
    public List<ModelVoiture> findAllModel() {
        return modelVoitureService.findAllModel();
    }

    @GetMapping("/nomModel/{nomModel}")
    public ModelVoiture findByNomModel(@PathVariable String nomModel) {
        return modelVoitureService.findByNomModel(nomModel);
    }

    @PostMapping("/")
    public int createModel(@RequestBody ModelVoiture modelVoiture) {
        return modelVoitureService.createModel(modelVoiture);
    }

}
