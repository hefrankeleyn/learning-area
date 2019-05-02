package com.hef.marco.controller;

import com.hef.marco.domain.Spittle;
import com.hef.marco.service.SpittleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.List;

/**
 * @Date 2019-05-01
 * @Author lifei
 */
@Controller
@RequestMapping(value = "/spittleController")
public class SpittleController {

    @Autowired
    private SpittleService spittleService;

    @RequestMapping(value = "/showSpittles", method = RequestMethod.GET)
    public String showSpittles(Model model){
        List<Spittle> spittleList = spittleService.findAllSpittle();
        model.addAttribute(spittleList);
        return "spittles";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveSpittle(Spittle spittle, Model model){
        spittle.setTime(new Date());
        Spittle save = spittleService.saveSpittle(spittle);
        model.addAttribute(save);
        return "spittle";
    }


}
