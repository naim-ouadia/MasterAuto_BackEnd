/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.model.Service;

import com.ncs.masterAuto.domain.bean.RoleUser;
import com.ncs.masterAuto.domain.bean.UserAccount;



/**
 *
 * @author wadie
 */
public interface AccountService {

    public UserAccount saveUser(String userName, String password, String confirmedPassword);

    public RoleUser saveRole(RoleUser roleUser);

    public UserAccount loadUserByUsername(String username);

    public void addRoleToUser(String userName, String roleName);
}
