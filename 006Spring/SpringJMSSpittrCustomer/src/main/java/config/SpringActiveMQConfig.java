package config;

import com.hef.spittr.domain.Spitter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date 2019-04-26
 * @Author lifei
 */
@Configuration
public class SpringActiveMQConfig {

    /**
     * 配置消息转换器
     * @return
     */
    @Bean
    public MappingJackson2MessageConverter messageConverter(){
        MappingJackson2MessageConverter messageConverter =
                new MappingJackson2MessageConverter();
        messageConverter.setEncoding("UTF-8");
        messageConverter.setTargetType(MessageType.TEXT);
        Map<String, Class<?>> typMap = new HashMap<>();
        typMap.put("spitter", Spitter.class);
        messageConverter.setTypeIdMappings(typMap);
        messageConverter.setTypeIdPropertyName("spitter");
        return messageConverter;
    }
}
