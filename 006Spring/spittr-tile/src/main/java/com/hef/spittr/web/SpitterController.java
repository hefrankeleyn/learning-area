package com.hef.spittr.web;

import com.hef.spittr.entities.Spitter;
import com.hef.spittr.service.SpitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/spitter")
public class SpitterController {


    private SpitterRepository spitterRepository;

    public SpitterController() {
    }

    @Autowired
    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository=spitterRepository;
    }
    /**
     *  处理"/spitter/register" 请求
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegisterForm(Model model) {
        model.addAttribute(new Spitter());
        return "registerForm";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(@Valid Spitter spitter,
                                      Errors errors) {
        if (errors.hasErrors()){
            return "registerForm";
        }
        spitterRepository.save(spitter);
        return "redirect:/spitter/"+spitter.getUsername();
    }

    @RequestMapping(value = "/{username}",method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username, Model model){
        Spitter spitter = spitterRepository.findByUsername(username);
        model.addAttribute(spitter);
        return "profile";
    }


    /**
     * 使用Spring jsp 表单绑定进行渲染
     * @param model
     * @return
     */
    @RequestMapping(value = "/register02")
    public String showRegisterForm02(Model model) {
        model.addAttribute(new Spitter());
        return "/jsplibview/registerForm";
    }


    @RequestMapping(value = "/register02", method = RequestMethod.POST)
    public String processRegistration02(@Valid Spitter spitter,
                                      Errors errors) {
        if (errors.hasErrors()){
            return "/jsplibview/registerForm";
        }
        spitterRepository.save(spitter);
        return "redirect:/spitter/"+spitter.getUsername();
    }
}
