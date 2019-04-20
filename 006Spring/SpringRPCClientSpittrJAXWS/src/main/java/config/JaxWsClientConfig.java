package config;

import com.hef.spittr.jaxws.client.SpitterServiceEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Date 2019-04-20
 * @Author lifei
 */
@Configuration
public class JaxWsClientConfig {

    @Bean
    public JaxWsPortProxyFactoryBean spitterService() throws MalformedURLException {
        JaxWsPortProxyFactoryBean portProxyFactoryBean = new JaxWsPortProxyFactoryBean();
        portProxyFactoryBean.setWsdlDocumentUrl(new URL("http://localhost:8088/services/SpitterService?wsdl"));
        portProxyFactoryBean.setServiceName("SpitterService");
        portProxyFactoryBean.setPortName("SpitterServiceEndpointPort");
        portProxyFactoryBean.setNamespaceUri("http://jaxws.remoting.spittr.hef.com/");
        portProxyFactoryBean.setServiceInterface(SpitterServiceEndpoint.class);
        return portProxyFactoryBean;
    }
}
