/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.model.Service.Impl;

import com.ncs.masterAuto.domain.bean.Rdv;
import com.ncs.masterAuto.domain.bean.RoleUser;
import com.ncs.masterAuto.domain.bean.Technicien;
import com.ncs.masterAuto.domain.bean.UserAccount;
import com.ncs.masterAuto.domain.model.Service.AccountService;
import com.ncs.masterAuto.domain.model.Service.TechnicienService;
import com.ncs.masterAuto.domain.model.dao.RoleUserDao;
import com.ncs.masterAuto.domain.model.dao.TechnicienDao;
import com.ncs.masterAuto.domain.model.dao.UserAccountDao;
import java.util.ArrayList;
import java.util.List;
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
    @Autowired
    private TechnicienService technicienService;
    @Autowired
    private TechnicienDao technicienDao;

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
        UserAccount userAccount = userAccountDao.findByAdresseMail(adresseMail);
        if (adresseMail.equals(" ") || adresseMail.equals("")) {
            return null;
        } else if (userAccount == null) {
            return null;
        }else{
            return userAccount;
        }
        
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        UserAccount user = userAccountDao.findByAdresseMail(userName);
        RoleUser role = roleUserDao.findByRolename(roleName);
        user.getRoles().add(role);

    }

    @Override
    public UserAccount upDateUser(long id, UserAccount userAccount) {
        UserAccount userAccount1 = userAccountDao.findById(id).get();
        if (userAccount1 == null) {
            return null;
        } else {
            userAccount.setId(id);
            userAccount.setPassword(bCryptPasswordEncoder.encode(userAccount.getPassword()));
            userAccount.setActived(true);
            userAccount.setRoles(userAccount1.getRoles());
            userAccountDao.save(userAccount);
            return userAccount;
        }
    }

    @Override
    public UserAccount addUserToTech(UserAccount userAccount) {
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
        addRoleToUser(userAccount.getAdresseMail(), "Technicien");
        technicienService.createTechnicien(userAccount);

        return u;
    }

    @Override
    public UserAccount blockedUser(Long id) {
        UserAccount userAccount = userAccountDao.findById(id - 1).get();
        Technicien technicien = technicienDao.findById(id).get();
        technicien.setActived(false);
        userAccount.setActived(false);
        userAccountDao.save(userAccount);
        return userAccount;
    }

    @Override
    public void deleteUserAndTech(long id) {
        userAccountDao.deleteById(id - 1);
        technicienDao.deleteById(id);
    }

    @Override
    public UserAccount activatedUer(Long id) {
        UserAccount userAccount = userAccountDao.findById(id - 1).get();
        Technicien technicien = technicienDao.findById(id).get();
        technicien.setActived(true);
        userAccount.setActived(true);
        userAccountDao.save(userAccount);
        return userAccount;
    }

    @Override
    public void deleteUser(long id) {
        userAccountDao.deleteById(id);
    }

    @Override
    public List<UserAccount> findAll() {
        return userAccountDao.findAll();
    }

    @Override
    public UserAccount blockedClient(Long id) {
        UserAccount userAccount = userAccountDao.findById(id).get();
        userAccount.setActived(false);
        userAccountDao.save(userAccount);
        return userAccount;
    }

    @Override
    public UserAccount activatedClient(Long id) {
        UserAccount userAccount = userAccountDao.findById(id).get();
        userAccount.setActived(true);
        userAccountDao.save(userAccount);
        return userAccount;
    }

    @Override
    public List<UserAccount> findByRdv(List<Rdv> rdvs) {
        List<UserAccount> users = new ArrayList<>();
        UserAccount userAccount = new UserAccount();
        for (Rdv rdv : rdvs) {
            userAccount = userAccountDao.findById(rdv.getUserAccount().getId()).get();
            users.add(userAccount);
        }
        return users;
    }

}
