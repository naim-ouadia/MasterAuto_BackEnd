/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.model.Service;

import com.ncs.masterAuto.domain.bean.Diagnostic;
import com.ncs.masterAuto.domain.bean.Mecanique;

/**
 *
 * @author wadie
 */
public interface MaintenanceService {

    public Mecanique saveMecanique(Mecanique mecanique);

    public Diagnostic saveDiagnostic(Diagnostic diagnostic);

    public int deleteMecanique(String nomMecanique);

    public int deleteDiagnostic(String nomDiagnostic);

}
