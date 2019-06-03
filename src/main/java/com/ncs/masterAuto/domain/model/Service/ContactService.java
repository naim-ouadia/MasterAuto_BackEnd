/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.model.Service;

import com.ncs.masterAuto.domain.bean.Contact;
import java.util.List;

/**
 *
 * @author wadie
 */
public interface ContactService {

    public int addNewContact(Contact contact);

    public List<Contact> findAllContact();

    public int deleteContact(Long id);

    public Contact editContact(Contact contact, Long id);
}
