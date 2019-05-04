package com.hef.contacts.dao.impl;

import com.hef.contacts.dao.ContactDao;
import com.hef.contacts.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Date 2019-05-04
 * @Author lifei
 */
@Repository
public class ContactDaoImpl implements ContactDao {

    private static final String SELECT_ALL = "select id, firstName, lastName, phoneNumber, emailAddress from contacts order by lastName";


    private static final String SAVE_ONE = "insert into contacts (firstName, lastName, phoneNumber, emailAddress) " +
            "values (?, ?, ?, ?)";
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Contact> findAll() {
        return jdbcTemplate.query(SELECT_ALL, (rs, rowNum) ->{
            Contact contact = new Contact();
            contact.setId(rs.getLong(1));
            contact.setFirstName(rs.getString(2));
            contact.setLastName(rs.getString(3));
            contact.setPhoneNumber(rs.getString(4));
            contact.setEmailAddress(rs.getString(5));
            return contact;
        });
    }

    @Override
    public void save(Contact contact) {
        jdbcTemplate.update(SAVE_ONE, contact.getFirstName(), contact.getLastName(), contact.getPhoneNumber(), contact.getEmailAddress());
    }
}
