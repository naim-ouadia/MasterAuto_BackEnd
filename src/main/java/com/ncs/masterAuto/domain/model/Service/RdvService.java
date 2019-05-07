/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.model.Service;

import com.ncs.masterAuto.domain.bean.Rdv;
import com.ncs.masterAuto.domain.bean.Technicien;
import java.util.Date;

/**
 *
 * @author wadie
 */
public interface RdvService {

    public Rdv createRdv(Rdv rdv);

    public Rdv findByTechnicien(Technicien technicien);

    public Rdv findByLogTech(String logTech);

    public Rdv findByDateRdv(Date dateRdv);

}
