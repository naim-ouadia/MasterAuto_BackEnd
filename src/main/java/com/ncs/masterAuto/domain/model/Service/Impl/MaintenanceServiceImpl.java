/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.model.Service.Impl;

import com.ncs.masterAuto.domain.bean.Diagnostic;
import com.ncs.masterAuto.domain.bean.Mecanique;
import com.ncs.masterAuto.domain.model.Service.MaintenanceService;
import com.ncs.masterAuto.domain.model.dao.DiagnosticDao;
import com.ncs.masterAuto.domain.model.dao.MecaniqueDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author wadie
 */
@Service
@Transactional
public class MaintenanceServiceImpl implements MaintenanceService {

    @Autowired
    private MecaniqueDao mecaniqueDao;
    @Autowired
    private DiagnosticDao diagnosticDao;

    @Override
    public Mecanique saveMecanique(Mecanique mecanique) {
        Mecanique mecanique1 = mecaniqueDao.findByNomMecanque(mecanique.getNomMecanque());
        if (mecanique == null) {
            throw new RuntimeException("mecanique est null");
        }
        if (mecanique1 != null) {
            throw new RuntimeException("cette catagorie existe déja ");
        }

        mecaniqueDao.save(mecanique);
        return mecanique;

    }

    @Override
    public Diagnostic saveDiagnostic(Diagnostic diagnostic) {
        Diagnostic mecanique1 = diagnosticDao.findByNomDiagnostic(diagnostic.getNomDiagnostic());
        if (diagnostic == null) {
            throw new RuntimeException("mecanique est null");
        }
        if (mecanique1 != null) {
            throw new RuntimeException("cette catagorie existe déja ");
        }
        diagnosticDao.save(diagnostic);
        return diagnostic;

    }

    @Override
    public void deleteMecanique(long id) {
        mecaniqueDao.deleteById(id);
    }

    @Override
    public void deleteDiagnostic(long id) {
        diagnosticDao.deleteById(id);

    }

    @Override
    public List<Mecanique> findAllMecanique() {
        return mecaniqueDao.findAll();
    }

    @Override
    public List<Diagnostic> findAllDiagnostic() {
        return diagnosticDao.findAll();
    }

    @Override
    public Mecanique findMecaniqueById(long id) {
        return mecaniqueDao.findById(id);
    }

    @Override
    public Mecanique updateMecanique(Mecanique mecanique, long id) {
        Mecanique mecanique1 = findMecaniqueById(id);
        if (mecanique1 == null) {
            return null;
        } else {
            mecanique.setId(id);
            mecaniqueDao.save(mecanique);
            return mecanique;
        }
    }

}
