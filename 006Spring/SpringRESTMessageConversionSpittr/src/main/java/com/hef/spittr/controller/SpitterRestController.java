package com.hef.spittr.controller;

import com.hef.spittr.domain.Spitter;
import com.hef.spittr.service.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Date 2019-04-21
 * @Author lifei
 */
@RestController
@RequestMapping("/spitter")
public class SpitterRestController {

    @Autowired
    private SpitterService spitterService;

    @RequestMapping(value = "findSpitterById", method = RequestMethod.GET)
    public Spitter findSpitterById(@RequestParam(value = "id", defaultValue = "1") long id){
        Spitter spitter = spitterService.getSpitter(id);
        return spitter;
    }


    /**
     * 注解 @ResponseBody 会告知Spring 跳过正常的模型/视图流程，并使用消息转换器。
     * 我们要返回的对象作为资源发送给客户端，并将其转换为客户端可以接受的表达形式
     * @return
     */
    @RequestMapping(value = "spitters",method = RequestMethod.GET, produces = "application/json")
    public List<Spitter> spitters(){
        return spitterService.getAllSpitters();
    }

    /**
     * 注解 @RequestBody 告诉Spring 查找一个消息转换器，将来自客户端的资源表述转换为对象
     * @param spitter
     * @return
     */
    @RequestMapping(value = "saveSpitter",method = RequestMethod.POST, consumes = "application/json")
    public Spitter saveSpitter(@RequestBody Spitter spitter){
        Spitter save = spitterService.saveSpitter(spitter);
        return save;
    }
}
