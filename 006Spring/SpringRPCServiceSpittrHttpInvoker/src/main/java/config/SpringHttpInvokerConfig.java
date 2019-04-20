package config;

import com.hef.spittr.service.SpitterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;

/**
 * @Date 2019-04-20
 * @Author lifei
 */
@Configuration
public class SpringHttpInvokerConfig {

    /**
     * 第一步；将 Spitter 服务导出为一个基于Http invoker 的服务
     *     由于HttpInvokerServiceExporter 是一个SpringMVC控制器， 我们需要建立一个URL处理器，映射HTTP URL到对应的服务上。
     * @param spitterService
     * @return
     */
    @Bean
    public HttpInvokerServiceExporter httpExportedSpitterService(SpitterService spitterService){
        HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
        exporter.setService(spitterService);
        exporter.setServiceInterface(SpitterService.class);
        return exporter;
    }
}
