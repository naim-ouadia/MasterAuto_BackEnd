/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domaine.rest.vo;

import java.util.Date;

/**
 *
 * @author wadie
 */
public class RdvVo {

    private Long id;
    private Date dateRdv;
    private ClientVo clientVo;
    private TechnicienVo technicienVo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateRdv() {
        return dateRdv;
    }

    public void setDateRdv(Date dateRdv) {
        this.dateRdv = dateRdv;
    }

    public ClientVo getClientVo() {
        return clientVo;
    }

    public void setClientVo(ClientVo clientVo) {
        this.clientVo = clientVo;
    }

    public TechnicienVo getTechnicienVo() {
        return technicienVo;
    }

    public void setTechnicienVo(TechnicienVo technicienVo) {
        this.technicienVo = technicienVo;
    }

}
