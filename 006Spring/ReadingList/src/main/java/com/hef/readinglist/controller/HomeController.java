package com.hef.readinglist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/**
 * @Date 2019-05-11
 * @Author lifei
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String home(){
        return "login";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String login(Principal principal){
        return "redirect:/readingList/"+principal.getName();
    }

}
