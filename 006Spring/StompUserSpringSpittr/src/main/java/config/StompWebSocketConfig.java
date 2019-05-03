package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @Date 2019-05-02
 * @Author lifei
 */
@Configuration
@EnableWebSocketMessageBroker   // 启用STOMP消息， 表明这个配置类，不仅配置了WebSocket， 还配置了基于代理的STOMP消息
public class StompWebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * 将 “/spittr” 注册为端点
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/spittr").withSockJS();
    }

    /**
     * 配置一个基于内存的消息代理
     * 消息代理会处理q点缀为：“/topic” 和 “/queue” 的消息
     * 除此之外，发往应用的消息会带有“/app” 前缀
     * @param registry
     */
    /*@Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic", "/queue");
        registry.setApplicationDestinationPrefixes("/app");
    }*/

    /**
     * 启用STOMP的代理中继
     * @param registry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 启用代理中继，
        registry.enableStompBrokerRelay("/topic", "/queue")
                .setRelayHost("localhost")
                .setRelayPort(61613)
                .setClientLogin("guest")
                .setClientPasscode("guest");
        // 目的地以 “/app” 开头的会路由到带有@MessageMapping的方法上
        registry.setApplicationDestinationPrefixes("/app");
    }
}
