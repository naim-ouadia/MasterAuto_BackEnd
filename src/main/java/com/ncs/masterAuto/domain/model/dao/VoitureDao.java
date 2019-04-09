/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.model.dao;

import com.ncs.masterAuto.domain.bean.CategorieVoiture;
import com.ncs.masterAuto.domain.bean.Client;
import com.ncs.masterAuto.domain.bean.MarqueVoiture;
import com.ncs.masterAuto.domain.bean.ModelVoiture;
import com.ncs.masterAuto.domain.bean.TypeCarburantVoiture;
import com.ncs.masterAuto.domain.bean.Voiture;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wadie
 */
@Repository
public interface VoitureDao extends JpaRepository<Voiture, Long> {

    public Voiture findByMarque(MarqueVoiture marque);

    public Voiture findByModel(ModelVoiture model);

    public Voiture findByCategorie(CategorieVoiture categorie);

    public Voiture findByTypeCarburant(TypeCarburantVoiture typeCarburant);

    public List<Voiture> findByClient(Client client);
    
}
