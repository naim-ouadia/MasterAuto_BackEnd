/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.model.Service;

import com.ncs.masterAuto.domain.bean.Rdv;
import com.ncs.masterAuto.domain.bean.Voiture;
import java.util.List;

/**
 *
 * @author wadie
 */
public interface VoitureService {

    public Voiture createVoiture(String marque, String model, String categorie, String caraburant);

    public List<Voiture> findByRdv(List<Rdv> rdvs);

}
