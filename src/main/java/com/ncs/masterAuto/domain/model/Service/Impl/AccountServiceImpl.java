/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.model.Service.Impl;

import com.ncs.masterAuto.domain.bean.RoleUser;
import com.ncs.masterAuto.domain.bean.UserAccount;
import com.ncs.masterAuto.domain.model.Service.AccountService;
import com.ncs.masterAuto.domain.model.dao.RoleUserDao;
import com.ncs.masterAuto.domain.model.dao.UserAccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author wadie
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private UserAccountDao userAccountDao;
    @Autowired
    private RoleUserDao roleUserDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserAccount saveUser(String userName, String password, String confirmedPassword) {
        UserAccount user = userAccountDao.findByUsername(userName);
        if (user != null) {
            throw new RuntimeException("utilisatuer deja existant ");

        }
        if (!password.equals(confirmedPassword)) {
            throw new RuntimeException("password et password de confirmation ne sont pas identique ");
        }
        UserAccount u = new UserAccount();
        u.setUsername(userName);
        u.setPassword(bCryptPasswordEncoder.encode(password));
        userAccountDao.save(u);
        addRoleToUser(userName, "USER");
        return u;
    }

    @Override
    public RoleUser saveRole(RoleUser roleUser) {
        return roleUserDao.save(roleUser);
    }

    @Override
    public UserAccount loadUserByUsername(String username) {
        return userAccountDao.findByUsername(username);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        UserAccount user = userAccountDao.findByUsername(userName);
        RoleUser role = roleUserDao.findByRolename(roleName);
        user.getRoles().add(role);

    }

}
