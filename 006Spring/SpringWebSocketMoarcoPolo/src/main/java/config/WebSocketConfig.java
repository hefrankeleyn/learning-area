package config;

import com.hef.ws.marcopolo.MarcoHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @Date 2019-04-29
 * @Author lifei
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        /**
         * 将 MarcoHandler 映射到 “/marco”
         */
        webSocketHandlerRegistry.addHandler(marcoHandler(), "/marco");
//        .setAllowedOrigins("http://localhost");
    }

    /**
     * 声明 MarcoHandler bean
     * @return
     */
    @Bean
    public MarcoHandler marcoHandler(){
        return new MarcoHandler();
    }
}
