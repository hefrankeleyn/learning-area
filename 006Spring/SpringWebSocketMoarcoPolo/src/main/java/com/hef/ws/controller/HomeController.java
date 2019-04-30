package com.hef.ws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Date 2019-04-30
 * @Author lifei
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {

    @RequestMapping(value = "home",method = RequestMethod.GET)
    public String home(){
        return "home";
    }
}
