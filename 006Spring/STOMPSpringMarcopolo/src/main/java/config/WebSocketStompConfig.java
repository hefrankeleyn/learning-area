package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @Date 2019-05-01
 * @Author lifei
 */
@Configuration
@EnableWebSocketMessageBroker   // 启用STOMP消息, 表明这个配置类不仅配置了WebSocket， 还配置了基于代理的STOMP消息
public class WebSocketStompConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * 为 "/marcopolo" 路径启用 SockJS 功能
     * 将 "/marcopolo" 注册为端点
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/marcopolo").withSockJS();
    }

    /**
     * 这个方法是可选的，默认会自动配置一个简单的内存消息代理，用来处理以“topic” 为前缀的消息。
     *
     * 在这里重载这个方法，所以消息代理将会处理前缀为 “topic” 和“queue”的消息
     * 除此之外，发往应用程序的消息将会带有“/app”前缀
     * @param registry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/queue", "/topic");
        registry.setApplicationDestinationPrefixes("/app");
    }

    /**
     * 启用STOMP代理中继
     * @param registry
     */
    /*@Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 第一行， 启用STOMP代理中继（broker relay) 功能）
        // 默认情况下，STOMP代理中继会假设代理监听localhost的61613端口，并且客户端的username和password均为guest
        registry.enableStompBrokerRelay("/topic", "/queue");
        // 第二行， 所有目的地以“/app”打头的消息都会路由到带有 @MessageMapping注解的方法中，而不会发布到代理队列或主题中
        // 注意，也可以配置多个应用前缀
        registry.setApplicationDestinationPrefixes("/app");
    }*/

    /**
     * 启用STOMP代理中继
     * @param registry
     */
    /*@Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 第一行， 启用STOMP代理中继（broker relay) 功能）
        // 默认情况下，STOMP代理中继会假设代理监听localhost的61613端口，并且客户端的username和password均为guest
        registry.enableStompBrokerRelay("/topic", "/queue")
                .setRelayHost("localhost")
                .setRelayPort(5672)
                .setClientLogin("guest")
                .setClientPasscode("guest");
        // 第二行， 所有目的地以“/app”打头的消息都会路由到带有 @MessageMapping注解的方法中，而不会发布到代理队列或主题中
        // 注意，也可以配置多个应用前缀
        registry.setApplicationDestinationPrefixes("/app");
    }*/
}
