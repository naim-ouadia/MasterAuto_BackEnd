/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.model.Service;

import com.ncs.masterAuto.domain.bean.RoleUser;
import com.ncs.masterAuto.domain.bean.User;

/**
 *
 * @author wadie
 */
public interface AccountService {

    public User saveUser(String userName, String password, String confirmedPassword);

    public RoleUser saveRole(RoleUser roleUser);

    public User loadUserByUsername(String username);

    public void addRoleToUser(String userName, String roleName);
}
