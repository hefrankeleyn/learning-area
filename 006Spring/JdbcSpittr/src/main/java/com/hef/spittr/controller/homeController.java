package com.hef.spittr.controller;

import com.hef.spittr.service.SpittlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class homeController {

    @Autowired
    private SpittlerService spittlerService;

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String homePage(){
        spittlerService.getConnection();
        return "home";
    }
}
