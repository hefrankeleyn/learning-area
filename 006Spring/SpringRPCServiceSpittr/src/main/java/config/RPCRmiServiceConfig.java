package config;

import com.hef.spittr.service.SpitterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

/**
 * 导出服务的第一种方案  Spring 继承RMI
 * @Date 2019-04-15
 * @Author lifei
 */
@Configuration
public class RPCRmiServiceConfig {

    /**
     * 使用RmiServiceExporter 将SpitterServiceImpl发布为RMI服务
     * 默认情况下RmiServiceExport 会尝试绑定到本地机器 1099 端口上的RMI注册表
     * 这就是使用Spring 把某个bean转变成RMI服务所需要做的全部工作
     * @param spitterService
     * @return
     */
    @Bean
    public RmiServiceExporter rmiExporter(SpitterService spitterService){
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceInterface(SpitterService.class);
        rmiServiceExporter.setService(spitterService);
        rmiServiceExporter.setServiceName(SpitterService.class.getSimpleName());
        rmiServiceExporter.setRegistryPort(1199);
        return rmiServiceExporter;
    }
}
