package config;

import com.hef.spittr.service.SpitterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import java.util.Properties;

/**
 * @Date 2019-04-18
 * @Author lifei
 */
@Configuration
public class RPCServiceHessianConfig {

    /**
     * 第一步：导出Hession服务
     * 1. 与RmiService不同的是， 这里不需要设置serviceName 属性， hession没有注册表，因此没有必要为Hession服务进行命名
     * 2. 由于Hession是基于Http的，所以HessionServiceExporter 实现 为一个SpringMVC控制器， 这意味着为了导出Hession服务，
     *    需要执行两个额外的配置步骤
     *    2.1 在web.xml 中配置Spring的DispatcherServlet，并把我们的应用部署为Web应用；
     *    2.2 在Spring的配置文件中配置一个URL处理器，把Hession服务的URL分发给对应的Hession服务bean
     * @return
     */
    @Bean
    public HessianServiceExporter hessianExportedSpitterService(SpitterService service){
        HessianServiceExporter exporter = new HessianServiceExporter();
        exporter.setService(service);
        exporter.setServiceInterface(SpitterService.class);
        return exporter;
    }

}
