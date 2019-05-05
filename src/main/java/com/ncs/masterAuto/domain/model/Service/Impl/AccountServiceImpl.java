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
    public UserAccount saveUser(UserAccount userAccount) {
        UserAccount user = userAccountDao.findByAdresseMail(userAccount.getAdresseMail());
        if (user != null) {
            throw new RuntimeException("utilisatuer deja existant ");

        }
       
        UserAccount u = new UserAccount();
        u.setAdresseMail(userAccount.getAdresseMail());
        u.setPassword(bCryptPasswordEncoder.encode(userAccount.getPassword()));
        u.setActived(true);
        u.setAdressePostale(userAccount.getAdressePostale());
        u.setNumTel(userAccount.getNumTel());
        u.setNom(userAccount.getNom());
        u.setPrenom(userAccount.getPrenom());
        userAccountDao.save(u);
        addRoleToUser(userAccount.getAdresseMail(), "User");
        return u;
    }

    @Override
    public RoleUser saveRole(RoleUser roleUser) {
        return roleUserDao.save(roleUser);
    }

    @Override
    public UserAccount loadUserByAdresseMail(String adresseMail) {
        return userAccountDao.findByAdresseMail(adresseMail);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        UserAccount user = userAccountDao.findByAdresseMail(userName);
        RoleUser role = roleUserDao.findByRolename(roleName);
        user.getRoles().add(role);

    }

}
