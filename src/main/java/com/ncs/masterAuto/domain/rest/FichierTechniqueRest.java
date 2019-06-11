/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.rest;

import com.ncs.masterAuto.domain.bean.FichierTechnique;
import com.ncs.masterAuto.domain.model.Service.FichierTechniqueService;
import com.ncs.masterAuto.domain.model.dao.FichierTechniqueDao;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author wadie
 */
@RestController
@RequestMapping("/master_Auto/FichierTechnique")
public class FichierTechniqueRest {

    @Autowired
    private FichierTechniqueService fichierTechniqueService;

    @Autowired
    private FichierTechniqueDao fichierTechniqueDao;

    @PostMapping("/AddNewFichier")
    public int addNewFichierTechnique(@RequestBody FichierTechnique fichierTechnique) {
        return fichierTechniqueService.addNewFichierTechnique(fichierTechnique);
    }

    @GetMapping("/FindAllFichierTechnique")
    public List<FichierTechnique> findAllFichierTechnique() {
        return fichierTechniqueService.findAllFichierTechnique();
    }

    @GetMapping("/FindById/{id}")
    public FichierTechnique findById(@PathVariable Long id) {
        return fichierTechniqueService.findById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteFichier(@PathVariable Long id) {
        return fichierTechniqueService.deleteFichier(id);
    }

    @PostMapping("/uploadFichierTechnique/{id}")
    public void uploadFichierTechnique(MultipartFile file, @PathVariable Long id) throws Exception {
        FichierTechnique fichierTechnique = fichierTechniqueDao.findById(id).get();
        fichierTechnique.setFichierTechnique(id + "pdf");
        Files.write(Paths.get(System.getProperty("user.home") + "/MasterAuto/fichiersTechnique/" + fichierTechnique.getFichierTechnique()), file.getBytes());
        fichierTechniqueDao.save(fichierTechnique);
    }

    @GetMapping(path = "/fichierPDF/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
    public @ResponseBody
    byte[] downloadPDF(@PathVariable Long id) throws IOException {
        FichierTechnique fichierTechnique = fichierTechniqueDao.findById(id).get();
        FileInputStream fis = new FileInputStream(new File("") + "C:/Users/wadie/MasterAuto/fichiersTechnique/" + fichierTechnique.getFichierTechnique() + ".pdf");
        byte[] targetArray = new byte[fis.available()];
        fis.read(targetArray);
        return targetArray;
    }

}
