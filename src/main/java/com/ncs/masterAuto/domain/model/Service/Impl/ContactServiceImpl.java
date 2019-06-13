/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.model.Service.Impl;

import com.ncs.masterAuto.domain.bean.Contact;
import com.ncs.masterAuto.domain.model.Service.ContactService;
import com.ncs.masterAuto.domain.model.dao.ContactDao;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author wadie
 */
@Service
@Transactional
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactDao contactDao;

    @Override
    public Contact addNewContact(Contact contact) {
        Contact contact1 = contactDao.findByNom(contact.getNom());
        if (contact == null) {
            return null;
        } else {
            contactDao.save(contact);
            return contact;
        }
    }

    @Override
    public int deleteContact(Long id) {
        Contact contact = contactDao.findById(id).get();
        if (contact == null) {
            return 1;
        } else {
            contactDao.deleteById(id);
            return 1;
        }
    }

    @Override
    public Contact upDateContact(Contact contact, Long id) {
        Contact contact1 = contactDao.findById(id).get();
        if (contact1 == null) {
            return null;
        } else {
            contact.setId(id);
            contactDao.save(contact);
            return contact;
        }
    }

    @Override
    public List<Contact> findAllContact() {
        return contactDao.findAll();
    }

    @Override
    public Contact findById(Long id) {
        return contactDao.findById(id).get();
    }

    @Override
    public List<Contact> getRechercheContact(String recherche) {
        if (recherche.equals("") || recherche.equals(" ")) {
            return null;
        }
        List<Contact> contacts = contactDao.findAll();
        List<Contact> listeContacts = new ArrayList<>();
        final String SEPARATEUR = " ";
        Contact contact = new Contact();
        String mots[] = recherche.split(SEPARATEUR);
        for (int i = 0; i < mots.length; i++) {
            for (int j = 0; j < contacts.size(); j++) {
                contact = contacts.get(j);
                if (contact.getNom().toUpperCase().contains(mots[i].toUpperCase()) == true || contact.getSpecialite().toUpperCase().contains(mots[i].toUpperCase()) == true) {
                    listeContacts.add(contact);
                }
            }
        }
        return listeContacts;
    }
}
