/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.rest;

import com.ncs.masterAuto.domain.bean.RoleUser;
import com.ncs.masterAuto.domain.bean.User;
import com.ncs.masterAuto.domain.model.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wadie
 */
@RestController
@RequestMapping("/master_Auto/users")
public class UserRest {

    @Autowired
    private AccountService accountService;

    @GetMapping("/userName/{userName}/password/{password}/confirmedPassword/{confirmedPassword}")
    public User saveUser(@PathVariable String userName, @PathVariable String password, @PathVariable String confirmedPassword) {
        return accountService.saveUser(userName, password, confirmedPassword);
    }

    public RoleUser save(RoleUser roleUser) {
        return accountService.save(roleUser);
    }

    @GetMapping("/username/{username}")
    public User loadUserByUsername(@PathVariable String username) {
        return accountService.loadUserByUsername(username);
    }

    public void addRoleToUser(String userName, String roleName) {
        accountService.addRoleToUser(userName, roleName);
    }
}
