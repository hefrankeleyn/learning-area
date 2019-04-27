package config;

import com.hef.spittr.service.JMSRPCService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.remoting.JmsInvokerServiceExporter;

/**
 * @Date 2019-04-27
 * @Author lifei
 */
@Configuration
public class JMSRPCServiceConfig {
    /**
     * 装配 导出器
     * @param service
     * @return
     */
    @Bean
    public JmsInvokerServiceExporter jmsInvokerServiceExporter(JMSRPCService service){
        JmsInvokerServiceExporter jmsInvokerServiceExporter = new JmsInvokerServiceExporter();
        jmsInvokerServiceExporter.setService(service);
        jmsInvokerServiceExporter.setServiceInterface(JMSRPCService.class);
        return jmsInvokerServiceExporter;
    }
}
