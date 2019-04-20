package config;

import com.hef.spittr.service.impl.SpitterServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

import javax.xml.ws.Endpoint;

/**
 * @Date 2019-04-20
 * @Author lifei
 */
@Configuration
public class JaxWsServiceConfig {


    /*public JaxWsServiceConfig() {
        Endpoint.publish("http://localhost:8080/SpitterService",new SpitterServiceImpl());
    }*/

    /**
     * 导出独立的JAX-WS端点
     * 会将使用JAX-WS 注解所标注的所有bean发布为 JAX-WS 服务
     * 当启动的时候，它会扫所Spring应用上下文来查找所有使用@WebService 注解的bean。
     * 当找到符合的bean时， SimpleJaxWsServiceExporter使用http://localhost:8080/地址发布为JAX-WS端点。
     * SpitterServiceEndpoint就是其中一个被查找到的bean
     * @return
     */
    @Bean
    public SimpleJaxWsServiceExporter jaxWsServiceExporter(){
        SimpleJaxWsServiceExporter exporter = new SimpleJaxWsServiceExporter();
        exporter.setBaseAddress("http://localhost:8088/services/");
        return exporter;
    }

   /* public static void main(String[] args) {

    }*/
}
