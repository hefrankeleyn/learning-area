package com.hef.spittr.dao;

import com.hef.spittr.domain.Spitter;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface SpitterDao {

    /**
     * 根据id查询
     * 在方法调用之前 会检查缓存中是否有值
     * 为接口方法添加注解后， @Cacheable 注解会被 该接口的所有实现继承
     * @param id
     * @return
     */
    @Cacheable(value = {"spitterCache"}, key = "#root.args[0]", unless = "#result != null and #result.updateByEmail.FALSE", condition = "#id >= 10")
    Spitter findSpitterById(Long id);

    /**
     * 查询所有
     * @return
     */
    List<Spitter> findAllSpitters();

    /**
     * 保存Spitter
     * key 的值是 SpEL 表达式的计算结果
     * @param spitter
     */
    @CachePut(value = {"spitterCache"}, key="#result.id")
    Spitter saveSpitter(Spitter spitter);

    /**
     * 查找最后一个
     * @return
     */
    Spitter findLastOne();

    /**
     * 根据id删除spitter
     * @param id
     */
    @CacheEvict(value = {"spitterCache"}, key = "#id")
    void deleteSpitterById(Long id);

}
