package config;

import com.hef.spittr.service.SpitterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

/**
 * @Date 2019-04-20
 * @Author lifei
 */
@Configuration
public class HttpInvokerClientConfig {

    /**
     * 配置客户端，调用基于HTTP invoker 的远程服务
     * @return
     */
    @Bean
    public HttpInvokerProxyFactoryBean spitterService(){
        HttpInvokerProxyFactoryBean proxyFactoryBean = new HttpInvokerProxyFactoryBean();
        proxyFactoryBean.setServiceUrl("http://localhost:8080/SpringRPCServiceSpittrHttpInvoker/spitter.service");
        proxyFactoryBean.setServiceInterface(SpitterService.class);
        return proxyFactoryBean;
    }
}
