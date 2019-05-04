package config;

import com.hef.spittr.domain.JmxTestBean;
import com.hef.spittr.domain.SpittleNotifierImpl;
import com.hef.spittr.jmx.SpittleControllerManagedOperations;
import com.hef.spittr.service.PagingNotificationListener;
import com.sun.tools.corba.se.idl.StringGen;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.access.MBeanProxyFactoryBean;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.jmx.export.annotation.AnnotationMBeanExporter;
import org.springframework.jmx.support.MBeanServerConnectionFactoryBean;
import org.springframework.jmx.support.RegistrationPolicy;

import javax.management.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Date 2019-05-03
 * @Author lifei
 */
@Configuration
@ComponentScan(basePackages = "com.hef.spittr.controller")
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
            proxyFactoryBean.setObjectName("spittle:name=SpittleController");
            proxyFactoryBean.setServer(mBeanServerConnection);
            proxyFactoryBean.setProxyInterface(SpittleControllerManagedOperations.class);
            return proxyFactoryBean;
        } catch (MalformedObjectNameException e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public MBeanExporter mBeanExporter(SpittleNotifierImpl spittleNotifier){
        MBeanExporter mBeanExporter = new MBeanExporter();
        String mapName = "spittle:name=PagingNotificationListener";
        Map<String, NotificationListener> mappings = new HashMap<>();

        Map<String, Object> beans = new HashMap<>();
        beans.put(mapName, spittleNotifier);
        mBeanExporter.setBeans(beans);
        mappings.put(mapName, new PagingNotificationListener());
        mBeanExporter.setNotificationListenerMappings(mappings);
        return mBeanExporter;
    }

    @Bean
    public JmxTestBean jmxTestBean(){
        JmxTestBean testBean = new JmxTestBean();
        testBean.setAge(23);
        testBean.setName("aaa");
        return testBean;
    }

    @Bean
    public SpittleNotifierImpl spittleNotifier(){
        return new SpittleNotifierImpl();
    }

}
