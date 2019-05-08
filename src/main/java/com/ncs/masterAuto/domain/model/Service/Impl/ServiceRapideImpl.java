/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.model.Service.Impl;

import com.ncs.masterAuto.domain.bean.ServiceRapide;
import com.ncs.masterAuto.domain.model.Service.ServiceRapideService;
import com.ncs.masterAuto.domain.model.dao.ServiceRapideDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author wadie
 */
@Service
@Transactional
public class ServiceRapideImpl implements ServiceRapideService {

    @Autowired
    private ServiceRapideDao serviceRapideDao;

    @Override
    public ServiceRapide saveServiceRapide(ServiceRapide serviceRapide) {
        ServiceRapide serviceRapide1 = serviceRapideDao.findByNomServiceRapide(serviceRapide.getNomServiceRapide());
        if (serviceRapide == null) {
            throw new RuntimeException("Service Rapide est null");
        }
        if (serviceRapide1 != null) {
            throw new RuntimeException("Service Rapide déja existant");
        }
        serviceRapideDao.save(serviceRapide);
        return serviceRapide;
    }

    @Override
    public int deleteServiceRapide(String nomService) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
