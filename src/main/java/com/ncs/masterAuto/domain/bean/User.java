/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.domain.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author wadie
 */
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //***** attributs *****//
    private Long id;
    // @Column(unique = true) //l'adresse mail doit etre unique dans la base de donnée
    private String userName;
    private String pwd;
//    private String pwdConfirmation;
    @ManyToMany//(fetch = FetchType.EAGER) // à chaque fois que JPA charge un User va charger aussi les roles de ce user
    private Collection<RoleUser> roles = new ArrayList<>();

    public User() {
    }

    public User(String userName, String pwd) {
        this.userName = userName;
        this.pwd = pwd;
    }

    public User(String userName, String pwd, Collection<GrantedAuthority> authorities) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

//    public String getPwdConfirmation() {
//        return pwdConfirmation;
//    }
//
//    public void setPwdConfirmation(String pwdConfirmation) {
//        this.pwdConfirmation = pwdConfirmation;
//    }
    public Collection<RoleUser> getRoles() {
        return roles;
    }

    public void setRoles(Collection<RoleUser> roles) {
        this.roles = roles;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ncs.masterAuto.domain.bean.Admin[ id=" + id + " ]";
    }

}
