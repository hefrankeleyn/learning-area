package config;

import net.sf.ehcache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableCaching         // 启用缓存
public class CachingConfig {

    /**
     * 声明缓存管理器，Spring3.1 内置了五个缓存管理实现，这里使用 ConcurrentMapCacheManager
     *
     * 缓存管理是Spring缓存抽象的核心， 它能够与多个流行的缓存实现进行集成
     * @return
     */
    /*@Bean
    public CacheManager cacheManager(){
        return new ConcurrentMapCacheManager();
    }*/

    /**
     * 声明缓存管理器， 使用 EhCacheCacheManager
     * @param cacheManager
     * @return
     */
    @Bean
    public EhCacheCacheManager cacheCacheManager(CacheManager cacheManager){
        EhCacheCacheManager ehCacheCacheManager = new EhCacheCacheManager(cacheManager);
        return ehCacheCacheManager;
    }

    /**
     * 使用 EhCacheManagerFactoryBean 来生成EhCache的CacheManager
     * @return
     */
    @Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean(){
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean =
                new EhCacheManagerFactoryBean();
        // 针对EhCache的配置
        ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("/cache/ehcache.xml"));
        return ehCacheManagerFactoryBean;
    }


}
