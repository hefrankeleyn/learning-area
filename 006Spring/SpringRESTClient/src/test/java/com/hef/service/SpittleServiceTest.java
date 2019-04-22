package com.hef.service;

import com.hef.spittr.domain.Spitter;
import com.hef.spittr.service.SpittleService;
import config.RootConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Date 2019-04-22
 * @Author lifei
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class SpittleServiceTest {

    @Autowired
    public SpittleService spittleService;

    @Test
    public void shouldNotNull(){
        Assert.assertNotNull(spittleService);
    }

    @Test
    public void fetchSpitterByIdTest(){
        Spitter spitter = spittleService.fetchSpitterById(1l);
        System.out.println(spitter);
    }

    @Test
    public void findSpitterByIdTest(){
        Spitter spitter = spittleService.findSpitterById(1l);
        System.out.println(spitter);
    }

    @Test
    public void getSpitterByIdTest(){
        Spitter spitter = spittleService.findSpitterById(1l);
        System.out.println(spitter);
    }

    @Test
    public void updateSpitter(){
        Spitter spitter = spittleService.getSpitterById(1l);
        System.out.println(spitter);

        spitter.setFullName("FUT spitter03");
        //spittleService.updateSpitter(spitter);
        //spittleService.updateSpitter(spitter);
        spittleService.updateSpitter(spitter);

        System.out.println("update Ok!");

        Spitter spitter2 = spittleService.getSpitterById(1l);
        System.out.println(spitter2);
    }

    @Test
    public void deleteSpitterById(){
        long id = 27l;
        /*Spitter spitter = spittleService.findSpitterById(id);
        System.out.println(spitter);
        Assert.assertNotNull(spitter);

        spittleService.deleteSpitterById(id);*/

        Spitter spitter2 = spittleService.findSpitterById(id);
        System.out.println(spitter2);
        Assert.assertNull(spitter2);
    }

    @Test
    public void saveSpitter(){
        Spitter spitter = new Spitter("rest save","rest", "rest", "rest@gmail.com", true);
//        Spitter saveSpitter = spittleService.saveSpitter(spitter);
        ResponseEntity<Spitter> responseEntity = spittleService.saveSpitterEntity(spitter);
        Spitter saveSpitter = responseEntity.getBody();
        System.out.println(responseEntity.getHeaders().getLocation());
        System.out.println(saveSpitter);
    }

    @Test
    public void saveSpitterAndGetLocation(){
        Spitter spitter = new Spitter("rest save","rest", "rest", "rest@gmail.com", true);
        String location = spittleService.saveSpitterAndFetchLocation(spitter);
        System.out.println(location);
    }

    @Test
    public void findSpitterByIdByExchange(){
        ResponseEntity<Spitter> res = spittleService.findSpitterByIdByExchange(1l);
        System.out.println(res.getBody());
        System.out.println(res);
    }
}
