package com.hef.spittr.controller;

import com.hef.spittr.domain.Spitter;
import com.hef.spittr.service.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Spitter findSpitterById(@PathVariable long id){
        Spitter spitter = spitterService.getSpitter(id);
        return spitter;
    }


    /**
     * 注解 @ResponseBody 会告知Spring 跳过正常的模型/视图流程，并使用消息转换器。
     * 我们要返回的对象作为资源发送给客户端，并将其转换为客户端可以接受的表达形式
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Spitter> spitters(){
        return spitterService.getAllSpitters();
    }

    // 版本一
    /**
     * 注解 @RequestBody 告诉Spring 查找一个消息转换器，将来自客户端的资源表述转换为对象
     * @param spitter
     * @return
     */
    /*@RequestMapping(value = "saveSpitter",method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody Spitter saveSpitter(@RequestBody Spitter spitter){
        Spitter save = spitterService.saveSpitter(spitter);
        return save;
    }*/

    // 版本二

    /**
     * HTTP 201 不仅能够表明请求成功完成，而且还能描述创建了新的资源
     * @param spitter
     * @return
     */
    /*@RequestMapping(value = "saveSpitter",method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody ResponseEntity<Spitter> saveSpitter(@RequestBody Spitter spitter){
        Spitter save = spitterService.saveSpitter(spitter);
        HttpHeaders headers = new HttpHeaders();
        URI locationUrl = URI.create("http://localhost:8080/spitters/findSpitterById?id=" + save.getId());
        headers.setLocation(locationUrl);
        ResponseEntity<Spitter> responseEntity = new ResponseEntity<>(save, headers, HttpStatus.CREATED);
        return responseEntity;
    }*/
    // 版本三：
    @RequestMapping(value = "saveSpitter",method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody ResponseEntity<Spitter> saveSpitter(@RequestBody Spitter spitter, UriComponentsBuilder ucb){
        Spitter save = spitterService.saveSpitter(spitter);
        HttpHeaders headers = new HttpHeaders();
        URI locationUrl = ucb.path("/spitters/findSpitterById").queryParam("id",save.getId()).build().toUri();

        headers.setLocation(locationUrl);
        ResponseEntity<Spitter> responseEntity = new ResponseEntity<>(save, headers, HttpStatus.CREATED);
        return responseEntity;
    }

    // 处理错误，第一个版本
    /*@RequestMapping(value = "findSpitterByName", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Spitter findSpitterByName(@RequestParam(value = "username") String username){
        Spitter spitter = spitterService.findSpitterByName(username);
        return spitter;

    }*/

    // 处理错误，第二个版本
    /*@RequestMapping(value = "findSpitterByName", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Spitter> findSpitterByName(@RequestParam(value = "username") String username){
        Spitter spitter = spitterService.findSpitterByName(username);
        HttpStatus status = spitter != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<Spitter>(spitter, status);
    }*/

    // 处理错误，第三个版本
    @RequestMapping(value = "findSpitterByName", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Spitter findSpitterByName(@RequestParam(value = "username") String username){
        Spitter spitter = spitterService.findSpitterByName(username);
        if (spitter == null) { throw new SpitterNotFoundException(username);}
        return spitter;
    }

    @ExceptionHandler(SpitterNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody Error spitterNotFound(SpitterNotFoundException e){
        String username = e.getUsername();
        Error error = new Error(4, "Spitter [" + username + "] not found");
        return error;
    }


    private class SpitterNotFoundException extends RuntimeException{
        private static final long serialVersionUID = 2L;
        private String username;

        public SpitterNotFoundException(String username){
            this.username = username;
        }

        public String getUsername() {
            return username;
        }
    }
}
