package com.hef.contacts.controller;

import com.hef.contacts.dao.ContactDao;
import com.hef.contacts.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * @Date 2019-05-04
 * @Author lifei
 */
@Controller
@RequestMapping(value = {"/", "/home"})
public class ContactController {

    @Autowired
    private ContactDao contactDao;

    /**
     * 处理GET "/"
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String home(Map<String, Object> model){
        List<Contact> all = contactDao.findAll();
        model.put("contacts", all);
        return "home";
    }

    /**
     * 处理 POST “/”
     * @param contact
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public String submit(Contact contact){
        contactDao.save(contact);
        return "redirect:/";
    }
}
