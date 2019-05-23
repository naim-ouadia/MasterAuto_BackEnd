/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.model.Service;

import com.ncs.masterAuto.domain.bean.Diagnostic;
import com.ncs.masterAuto.domain.bean.Mecanique;
import java.util.List;

/**
 *
 * @author wadie
 */
public interface MaintenanceService {

    public Mecanique saveMecanique(Mecanique mecanique);

    public Diagnostic saveDiagnostic(Diagnostic diagnostic);

    public List<Diagnostic> findAllDiagnostic();

    public List<Mecanique> findAllMecanique();

    public void deleteMecanique(long id);

    public void deleteDiagnostic(long id);

    public Mecanique findMecaniqueById(long id);

    public Diagnostic findDiagnosticById(long id);

    public Mecanique updateMecanique(Mecanique mecanique, long id);

    public Diagnostic updateDiagnostic(Diagnostic diagnostic, long id);

}
