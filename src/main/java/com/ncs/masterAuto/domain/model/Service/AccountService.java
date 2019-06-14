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

    public UserAccount saveUser(UserAccount userAccount);

    public RoleUser saveRole(RoleUser roleUser);

    public UserAccount loadUserByAdresseMail(String adresseMail);

    public UserAccount upDateUser(long id, UserAccount userAccount);

    public void addRoleToUser(String userName, String roleName);

    public UserAccount addUserToTech(UserAccount userAccount);
}
