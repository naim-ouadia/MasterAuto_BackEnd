/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.security;

import com.ncs.masterAuto.domain.bean.Client;
import com.ncs.masterAuto.domain.model.Service.ClientService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author wadie
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ClientService clientService;

    @Override
    public UserDetails loadUserByUsername(String adresseMail) throws UsernameNotFoundException {
        Client client = clientService.findByAdresseMail(adresseMail);
        if (client == null) {
            throw new UsernameNotFoundException("client non  trouvé");
        }
        Collection<? extends GrantedAuthority> authorities = null;
        return new User(client.getAdresseMail(), client.getPwd(), authorities);
    }

}
