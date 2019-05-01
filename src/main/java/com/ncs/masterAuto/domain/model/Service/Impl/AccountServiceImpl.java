/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.model.Service.Impl;

import com.ncs.masterAuto.domain.bean.RoleUser;
import com.ncs.masterAuto.domain.bean.User;
import com.ncs.masterAuto.domain.model.Service.AccountService;
import com.ncs.masterAuto.domain.model.dao.RoleUserDao;
import com.ncs.masterAuto.domain.model.dao.UserDao;
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
    private UserDao userDao;
    @Autowired
    private RoleUserDao roleUserDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User saveUser(String userName, String password, String confirmedPassword) {
        User user = userDao.findByUserName(userName);
        if (user != null) {
            throw new RuntimeException("utilisatuer deja existant ");

        }
        if (!password.equals(confirmedPassword)) {
            throw new RuntimeException("password et password de confirmation ne sont pas identique ");
        }
        User u = new User();
        u.setUserName(userName);
        u.setPwd(bCryptPasswordEncoder.encode(password));
        userDao.save(u);
        addRoleToUser(userName, "USER");
        return u;
    }

    @Override
    public RoleUser saveRole(RoleUser roleUser) {
        return roleUserDao.save(roleUser);
    }

    @Override
    public User loadUserByUsername(String username) {
        return userDao.findByUserName(username);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        User user = userDao.findByUserName(userName);
        RoleUser role = roleUserDao.findByRoleName(roleName);
        user.getRoles().add(role);

    }

}
