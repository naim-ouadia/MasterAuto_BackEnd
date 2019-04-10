/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.model.Service;

import com.ncs.masterAuto.domain.bean.CategorieVoiture;
import com.ncs.masterAuto.domain.bean.Client;
import com.ncs.masterAuto.domain.bean.MarqueVoiture;
import com.ncs.masterAuto.domain.bean.ModelVoiture;
import com.ncs.masterAuto.domain.bean.TypeCarburant;
import com.ncs.masterAuto.domain.bean.Voiture;
import java.util.List;

/**
 *
 * @author wadie
 */
public interface VoitureService {

    public int createVoiture(Voiture voiture);

    public Voiture findByMarque(MarqueVoiture marque);

    public Voiture findByModel(ModelVoiture model);

    public Voiture findByCategorie(CategorieVoiture categorie);

    public Voiture findByTypeCarburant(TypeCarburant typeCarburant);

    public List<Voiture> findByClient(Client client);
}
