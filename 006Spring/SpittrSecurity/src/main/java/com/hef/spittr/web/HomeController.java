package com.hef.spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description @Controller 声明为一个控制器，这个注解是一个构造性注解，是基于@Component
 *               处理对 “/” 的GET请求， 视图名为home
 *
 */
/*
//  方法级别的请求处理
@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "home";
    }
}
*/

// 类级别的请求处理
@Controller
@RequestMapping(value = {"/", "/homepage"})
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        return "home";
    }


    @RequestMapping(value = "/home2", method = RequestMethod.GET)
    public String home02() {
        return "/jsplibview/home";
    }
}


