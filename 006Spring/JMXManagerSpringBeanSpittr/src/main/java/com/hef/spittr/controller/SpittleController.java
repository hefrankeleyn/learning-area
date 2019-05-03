package com.hef.spittr.controller;

import com.hef.spittr.domain.Spittle;
import com.hef.spittr.service.SpittleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Date 2019-05-03
 * @Author lifei
 */
@Controller
@RequestMapping(value = {"/spittleController"})
public class SpittleController {
    @Autowired
    private SpittleService spittleService;

    public static final int DEFAULT_SPITTLES_PER_PAGE = 25;
    private int spittlesPerPage = DEFAULT_SPITTLES_PER_PAGE;


    @RequestMapping(value = "/showSpittles", method = RequestMethod.GET)
    public String findSomeSpittle(Model model){
        List<Spittle> spittleList = spittleService.getRecentSpittles(spittlesPerPage);
        model.addAttribute(spittleList);
        return "spittles";
    }

    public int getSpittlesPerPage() {
        return spittlesPerPage;
    }

    public void setSpittlesPerPage(int spittlesPerPage) {
        this.spittlesPerPage = spittlesPerPage;
    }
}
