/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.rest;

import com.ncs.masterAuto.domain.bean.Diagnostic;
import com.ncs.masterAuto.domain.bean.Mecanique;
import com.ncs.masterAuto.domain.model.Service.MaintenanceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wadie
 */
@RestController
@RequestMapping("/master_Auto/maintenance")
public class MaintenanceRest {

    @Autowired
    private MaintenanceService maintenanceService;

    @GetMapping("/AllDiagnostic")
    public List<Diagnostic> findAllDiagnostic() {
        return maintenanceService.findAllDiagnostic();
    }
    @GetMapping("/AllMecanique")
    public List<Mecanique> findAllMecanique() {
        return maintenanceService.findAllMecanique();
    }

    @PostMapping("/createMecanique")
    public Mecanique saveMecanique(@RequestBody Mecanique mecanique) {
        return maintenanceService.saveMecanique(mecanique);
    }

    @PostMapping("/createDiagnostic")
    public Diagnostic saveDiagnostic(@RequestBody Diagnostic diagnostic) {
        return maintenanceService.saveDiagnostic(diagnostic);
    }

    public int deleteMecanique(String nomMecanique) {
        return maintenanceService.deleteMecanique(nomMecanique);
    }

    public int deleteDiagnostic(String nomDiagnostic) {
        return maintenanceService.deleteDiagnostic(nomDiagnostic);
    }
}
