package com.hef.spittr.dao;

import com.hef.spittr.domain.Spitter;
import config.RootConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Method;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class SpitterDaoCachingTest {

    @Autowired
    private SpitterDao spitterDao;

    @Test
    public void shouldNotNull(){
        Assert.assertNotNull(spitterDao);
    }

    @Test
    public void findSpitterByIdCaching(){
        Spitter spitter = spitterDao.findSpitterById(11L);
        System.out.println(spitter);
        Assert.assertNotNull(spitter);
        //测试缓存， 没有添加缓存注解时，控制台打印两次日志，添加了注解，控制台只打印一次日志
        Spitter spitter02 = spitterDao.findSpitterById(11L);
        System.out.println(spitter02);
        Assert.assertNotNull(spitter02);
        Spitter spitter03 = spitterDao.findSpitterById(2L);
        System.out.println(spitter03);
        Assert.assertNotNull(spitter03);
        readAnnotation();
    }

    private void readAnnotation(){
        try {
            Method method = SpitterDao.class.getMethod("findSpitterById", Long.class);
            Cacheable ca = method.getAnnotation(Cacheable.class);
            System.out.println(ca);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void saveCachingTest(){
        Spitter s = new Spitter(
                "xiaoMing",
                "hong",
                "hong",
                "hong@gmail.com",
                true);
        Spitter spitter = spitterDao.saveSpitter(s);
        Assert.assertNotNull(spitter);
        Spitter spitterById = spitterDao.findSpitterById(spitter.getId());
        System.out.println(spitterById);
        Spitter spitter02 = spitterDao.findSpitterById(1L);
        System.out.println(spitter02);

    }

    @Test
    public void deleteSpitterTest(){
        Spitter spitter16 = spitterDao.findSpitterById(16L);
        System.out.println(spitter16);
        Spitter spitter = spitterDao.findSpitterById(17L);
        System.out.println(spitter);
        Assert.assertNotNull(spitter);
        spitterDao.deleteSpitterById(17L);
        Spitter spitter02 = spitterDao.findSpitterById(17L);
        System.out.println(spitter02);
        Assert.assertNull(spitter02);
        Spitter spitter16_2 = spitterDao.findSpitterById(16L);
        System.out.println(spitter16_2);
        Assert.assertNotNull(spitter16_2);
    }


}
