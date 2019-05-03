package config;

import com.hef.spittr.jmx.SpittleControllerManagedOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.access.MBeanProxyFactoryBean;
import org.springframework.jmx.support.MBeanServerConnectionFactoryBean;

import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import java.net.MalformedURLException;

/**
 * @Date 2019-05-03
 * @Author lifei
 */
@Configuration
public class MBeanConfig {

    /**
     * 该bean用于访问基于RMI的远程服务器，它能够以MBeanServerConnection的形式注入到其他bean中
     * @return
     */
    @Bean
    public MBeanServerConnectionFactoryBean connectionFactoryBean(){
        MBeanServerConnectionFactoryBean mBeanServerConnectionFactoryBean =
                new MBeanServerConnectionFactoryBean();
        try {
            mBeanServerConnectionFactoryBean.setServiceUrl("service:jmx:rmi://localhost/jndi/rmi://localhost:1199/spittle");
            return mBeanServerConnectionFactoryBean;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 使用代理
     * @param mBeanServerConnection
     * @return
     */
    @Bean
    public MBeanProxyFactoryBean remoteSpittleControllerMBean(MBeanServerConnection mBeanServerConnection){
        MBeanProxyFactoryBean proxyFactoryBean = new MBeanProxyFactoryBean();
        try {
            proxyFactoryBean.setObjectName("spitter:name=SpittleController");
            proxyFactoryBean.setServer(mBeanServerConnection);
            proxyFactoryBean.setProxyInterface(SpittleControllerManagedOperations.class);
            return proxyFactoryBean;
        } catch (MalformedObjectNameException e) {
            throw new RuntimeException(e);
        }
    }

}
