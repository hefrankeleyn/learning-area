package config;

import com.hef.spittr.service.SpitterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.BurlapProxyFactoryBean;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

/**
 * @Date 2019-04-18
 * @Author lifei
 */
@Configuration
public class RPCClientHessionConfig {

    /**
     * 访问Hession服务
     * @return
     */
    /*@Bean
    public HessianProxyFactoryBean spitterService(){
        HessianProxyFactoryBean proxyFactoryBean = new HessianProxyFactoryBean();
        proxyFactoryBean.setServiceUrl("http://localhost:8080/SpringRPCServiceSpittrCauchoTechnology/spitter.service");
        proxyFactoryBean.setServiceInterface(SpitterService.class);
        return proxyFactoryBean;
    }*/

    /**
     * 访问Burlap 服务
     * @return
     */
    @Bean
    public BurlapProxyFactoryBean spitterService(){
        BurlapProxyFactoryBean proxyFactoryBean = new BurlapProxyFactoryBean();
        proxyFactoryBean.setServiceUrl("http://localhost:8080/SpringRPCServiceSpittrCauchoTechnology/spitter.service");
        proxyFactoryBean.setServiceInterface(SpitterService.class);
        return proxyFactoryBean;
    }


}
