package config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MultiCachingConfig {

    /*public CacheManager cacheManager(net.sf.ehcache.CacheManager cm,
                                     javax.cache.CacheManager jcm,
                                     RedisCacheManager rcm){
        CompositeCacheManager cacheManager = new CompositeCacheManager();
        List<CacheManager> managers = new ArrayList<>();
        managers.add(new JCacheCacheManager(jcm));
        managers.add(new EhCacheCacheManager(cm));
        managers.add(rcm);
        cacheManager.setCacheManagers(managers);
        return cacheManager;
    }*/
}
