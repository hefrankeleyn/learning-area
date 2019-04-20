package com.hef.spittr.remoting.jaxws;

import com.hef.spittr.domain.Spitter;
import com.hef.spittr.service.SpitterService;
import com.hef.spittr.service.impl.SpitterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.List;

/**
 * 在Spring中自动装配JAX-WS端点
 * 使用@WebService 注解所标注的类 被认为Web服务的断点
 * 使用@WebMethod 注解所标注的方法被认为是操作
 * 装配JAX-WS 断点
 * @Date 2019-04-20
 * @Author lifei
 */
@Component
@WebService(serviceName = "SpitterService")
public class SpitterServiceEndpoint extends SpringBeanAutowiringSupport{

    // 标注断点的属性
    @Autowired
    SpitterService spitterService;


    // 委托给 SpitterService
    // 使用 @WebMethod 注解 所标注的方法被认为是操作
    @WebMethod
    public void saveSpitter(Spitter spitter){
        spitterService.saveSpitter(spitter);
    }
    @WebMethod
    public Spitter findSpitterById(long id){
        return spitterService.getSpitter(id);
    }
    @WebMethod
    public List<Spitter> findAllSpitters(){
        return spitterService.getAllSpitters();
    }
}
