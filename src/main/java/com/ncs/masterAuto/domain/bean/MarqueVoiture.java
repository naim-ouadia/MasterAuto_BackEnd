/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.bean;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.ui.Model;

/**
 *
 * @author wadie
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MarqueVoiture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomMarque;
//    @ManyToOne(fetch = FetchType.EAGER)
//    private List<Model> models;
}
