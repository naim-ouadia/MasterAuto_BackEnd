/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.rest;

import com.ncs.masterAuto.domain.bean.RoleUser;
import com.ncs.masterAuto.domain.bean.UserAccount;
import com.ncs.masterAuto.domain.model.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wadie
 */
@RestController
@RequestMapping("/master_Auto/users")
public class AccountRest {

    @Autowired
    private AccountService accountService;

    
    @PostMapping("/newRole")
    public RoleUser saveRole(@RequestBody RoleUser roleUser) {
        return accountService.saveRole(roleUser);
    }

    @GetMapping("/adresseMail/{adresseMail}")
    public UserAccount loadUserByUsername(@PathVariable String adresseMail) {
        return accountService.loadUserByAdresseMail(adresseMail);
    }

    @GetMapping("/adresseMail/{adresseMail}/roleName/{roleName}")
    public void addRoleToUser(@PathVariable String adresseMail,
            @PathVariable String roleName) {
        accountService.addRoleToUser(adresseMail, roleName);
    }

    @PostMapping("/register")
    public UserAccount register(@RequestBody UserAccount userAccount) {
        return accountService.saveUser(userAccount);
    }
    
    @PutMapping("/upDateUser/{id}")
    public UserAccount upDateUser(@PathVariable long id,@RequestBody UserAccount userAccount) {
        return accountService.upDateUser(id, userAccount);
    }

}
