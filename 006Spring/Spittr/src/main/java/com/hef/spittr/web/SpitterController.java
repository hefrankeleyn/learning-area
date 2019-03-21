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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Part;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

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
     * @return register view path
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegisterForm() {
        return "registerForm";
    }

    @RequestMapping(value = "/register2", method = RequestMethod.GET)
    public String showRegisterForm2() {
        return "/jsplibview/registerForm";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(@RequestPart("profilePicture") MultipartFile profilePicture,
                                      @Valid Spitter spitter,
                                      Errors errors, Model model) throws IOException {
        if (errors.hasErrors()){
            return "registerForm";
        }
        // 将上传的图片文件写入到文件系统中
        profilePicture.transferTo(new File("/Users/lifei/Documents/servers/spittr/" +profilePicture.getOriginalFilename()));

        spitterRepository.save(spitter);
        // 使用模板数据的方式来定义重定向的URL, 会对不安全字符进行过滤
        model.addAttribute("username", spitter.getUsername());
        model.addAttribute("spitterId", spitter.getsId());
        // 没有匹配到重定向 URL中的任何占位符，它会自动以查询参数的形式附加到重定向的URL上
        // /spitter/habuma?spitterId=23

        return "redirect:/spitter/{username}";
    }

    @RequestMapping(value = "register2", method = RequestMethod.POST)
    public String processRegistration02(@RequestPart("profilePicture")Part profilePicture,
                                        @Valid Spitter spitter,
                                        Errors errors, RedirectAttributes model) throws IOException {
        if(errors.hasErrors()){
            return "/jsplibview/registerForm";
        }
        profilePicture.write("/Users/lifei/Documents/servers/spittr/" + profilePicture.getSubmittedFileName());
        spitterRepository.save(spitter);
        model.addAttribute("username", spitter.getUsername());
        model.addFlashAttribute(spitter);
        return "redirect:/spitter/{username}";
    }


    @RequestMapping(value = "/{username}",method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username, Model model){
        if (!model.containsAttribute("spitter")){
            Spitter spitter = spitterRepository.findByUsername(username);
            model.addAttribute(spitter);
        }
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
