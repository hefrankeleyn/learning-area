package config;

import com.hef.ws.marcopolo.MarcoHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @Date 2019-05-01
 * @Author lifei
 */
@Configuration
@EnableWebSocket
public class SockJSConfig implements WebSocketConfigurer {


    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        // 通过 withSockJS() 方法返回 WebSocketHandlerRegistry

        webSocketHandlerRegistry.addHandler(marcoHandler(), "/marco").withSockJS();
    }

    @Bean
    public MarcoHandler marcoHandler(){
        return new MarcoHandler();
    }
}
