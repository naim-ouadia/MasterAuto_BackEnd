/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.rest;

import com.ncs.masterAuto.domain.bean.ServiceRapide;
import com.ncs.masterAuto.domain.model.Service.ServiceRapideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wadie
 */
@RestController
@RequestMapping("/master_Auto/ServiceRapide")
public class ServiceRapideRest {

    @Autowired
    private ServiceRapideService serviceRapideService;

    @PostMapping("/createServiceRapide")
    public ServiceRapide saveServiceRapide(@RequestBody ServiceRapide serviceRapide) {
        return serviceRapideService.saveServiceRapide(serviceRapide);
    }

    public int deleteServiceRapide(String nomService) {
        return serviceRapideService.deleteServiceRapide(nomService);
    }
}
