/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.model.dao;

import com.ncs.masterAuto.domain.bean.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wadie
 */
@Repository
public interface UserAccountDao extends JpaRepository<UserAccount, Long> {

   public UserAccount findByUsername(String userName);
}
