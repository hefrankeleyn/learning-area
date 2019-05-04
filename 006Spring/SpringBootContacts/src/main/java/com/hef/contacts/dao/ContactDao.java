package com.hef.contacts.dao;

import com.hef.contacts.domain.Contact;

import java.util.List;

/**
 * @Date 2019-05-04
 * @Author lifei
 */
public interface ContactDao {

    List<Contact> findAll();

    void save(Contact contact);
}
