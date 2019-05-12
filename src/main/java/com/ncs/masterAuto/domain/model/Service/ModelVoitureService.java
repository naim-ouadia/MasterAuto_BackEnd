/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.model.Service;

import com.ncs.masterAuto.domain.bean.ModelVoiture;
import java.util.List;

/**
 *
 * @author wadie
 */
public interface ModelVoitureService {

    public ModelVoiture findByNomModel(String nomModel);

    public int createModel(ModelVoiture modelVoiture);

    public List<ModelVoiture> findAllModel();
}
