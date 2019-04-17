package config;

import com.hef.spittr.service.SpitterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

/**
 * @Date 2019-04-15
 * @Author lifei
 */
@Configuration
public class RPCRmiClientConfig {

    /**
     * 服务的URL是通过 RmiProxyFactoryBean 的 serviceUrl 属性来设置的。
     * 在这里，服务名被设置为 SpitterService，并声明服务在本地机器上。
     *
     * 现在已经把RMI服务声明为Spring管理的bean， 我们可以把它作为依赖装配进另一个bean中
     * @return
     */
    @Bean
    public RmiProxyFactoryBean spitterService(){
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceUrl("rmi://localhost:1199/"+SpitterService.class.getSimpleName());
        rmiProxyFactoryBean.setServiceInterface(SpitterService.class);
        return rmiProxyFactoryBean;
    }
}
