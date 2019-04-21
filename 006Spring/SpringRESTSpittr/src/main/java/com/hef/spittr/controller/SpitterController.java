package com.hef.spittr.controller;

import com.hef.spittr.domain.Spitter;
import com.hef.spittr.service.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Date 2019-04-21
 * @Author lifei
 */
@Controller
@RequestMapping("/spitters")
public class SpitterController {

    @Autowired
    private SpitterService spitterService;

    @RequestMapping(value = "findSpitterById", method = RequestMethod.GET)
    public String findSpitterById(@RequestParam(value = "id", defaultValue = "1") long id, Model model){
        Spitter spitter = spitterService.getSpitter(id);
        model.addAttribute(spitter);
        return "profile";
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<Spitter> spitters(){
        return spitterService.getAllSpitters();
    }
}
