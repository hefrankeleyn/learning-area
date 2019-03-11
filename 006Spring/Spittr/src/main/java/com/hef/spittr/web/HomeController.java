package com.hef.spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description @Controller 声明为一个控制器，这个注解是一个构造性注解，是基于@Component
 *               处理对 “/” 的GET请求， 视图名为home
 *
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "home";
    }
}
