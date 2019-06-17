/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.model.Service;

import com.ncs.masterAuto.domain.bean.Rdv;
import java.util.List;

/**
 *
 * @author wadie
 */
public interface RdvService {

    public Rdv createRdv(long idClient, long idVoiture, String dateRdv, String commentaire);

    public List<Rdv> findByTechnicien(long id);

    public List<Rdv> findListRdvById(long id);

    public int rdvParMois(String mois);

    public List<Rdv> findAllRdv();

}
