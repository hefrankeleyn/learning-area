package com.hef.spittr.controller;

import com.hef.spittr.domain.Spittle;
import com.hef.spittr.service.SpittleNotifier;
import com.hef.spittr.service.SpittleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
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
//@ManagedResource(objectName = "spittle:name=SpittleController")   // 将SpittleController导出为bean
public class SpittleController {
    @Autowired
    private SpittleService spittleService;

    @Autowired
    private SpittleNotifier spittleNotifier;

    public static final int DEFAULT_SPITTLES_PER_PAGE = 25;
    private int spittlesPerPage = DEFAULT_SPITTLES_PER_PAGE;


    @RequestMapping(value = "/showSpittles", method = RequestMethod.GET)
    public String findSomeSpittle(Model model){
        List<Spittle> spittleList = spittleService.getRecentSpittles(spittlesPerPage);
        model.addAttribute(spittleList);
        // 发送通知
        spittleNotifier.millionthSpittlePosted();
        return "spittles";
    }

//    @ManagedAttribute   // 将spittlesPaerPage暴露为托管属性
    public int getSpittlesPerPage() {
        return spittlesPerPage;
    }

//    @ManagedAttribute // 将spittlesPaerPage暴露为托管属性
    public void setSpittlesPerPage(int spittlesPerPage) {
        this.spittlesPerPage = spittlesPerPage;
    }

    @RequestMapping(value = "/spittles", method = RequestMethod.GET)
    public String spittles(Model model){
        List<Spittle> allSpittle = spittleService.findAllSpittle();
        model.addAttribute(allSpittle);
        return "spittles";
    }
}
