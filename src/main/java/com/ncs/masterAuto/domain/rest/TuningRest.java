/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.rest;

import com.ncs.masterAuto.domain.bean.Tuning;
import com.ncs.masterAuto.domain.model.Service.TuningService;
import com.ncs.masterAuto.domain.model.dao.TuningDao;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author wadie
 */
@RestController
@RequestMapping("/master_Auto/Tuning")
public class TuningRest {

    @Autowired
    private TuningService tuningService;
    @Autowired
    private TuningDao tuningDao;

    @GetMapping("/getAllTuning")
    public List<Tuning> findAllTuning() {
        return tuningService.findAllTuning();
    }

    @PostMapping("/creatTuning")
    public Tuning saveTuning(@RequestBody Tuning tuning) {
        return tuningService.saveTuning(tuning);
    }

    public int deleteTuning(String nomTuning) {
        return tuningService.deleteTuning(nomTuning);
    }

    @PostMapping("/uploadPhoto/{id}")
    public void uploadPhoto(MultipartFile file, @PathVariable Long id) throws Exception {
        Tuning tuning = tuningDao.findById(id).get();
        tuning.setImage(id + "jpg");
        Files.write(Paths.get(System.getProperty("user.home") + "/MasterAuto/" + tuning.getImage()), file.getBytes());
        tuningDao.save(tuning);
    }

    @GetMapping(path = "/photo/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception {
        Tuning tuning = tuningDao.findById(id).get();
        return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/MasterAuto/" + tuning.getImage()));

    }
}
