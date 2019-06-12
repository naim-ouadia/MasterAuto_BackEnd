/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.rest;

import com.ncs.masterAuto.domain.bean.Contact;
import com.ncs.masterAuto.domain.model.Service.ContactService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/master_Auto/Contact")
public class ContactRest {

    @Autowired
    private ContactService contactService;

    @PostMapping("/addNewContact")
    public Contact addNewContact(@RequestBody Contact contact) {
        return contactService.addNewContact(contact);
    }

    @GetMapping("/getAllContact")
    public List<Contact> findAllContact() {
        return contactService.findAllContact();
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteContact(@PathVariable Long id) {
        return contactService.deleteContact(id);
    }

    @PutMapping("/upDateContact/{id}")
    public Contact upDateContact(@RequestBody Contact contact, @PathVariable Long id) {
        return contactService.upDateContact(contact, id);
    }

    @GetMapping("/getContact/{id}")
    public Contact findById(@PathVariable Long id) {
        return contactService.findById(id);
    }

}
