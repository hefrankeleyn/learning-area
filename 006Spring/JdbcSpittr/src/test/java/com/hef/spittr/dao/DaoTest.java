package com.hef.spittr.dao;


import com.hef.spittr.entities.Spittler;
import com.hef.spittr.service.NamedParametersSpittlerService;
import com.hef.spittr.service.SpittlerService;
import com.hef.spittr.service.TemplateSpitterService;
import config.RootConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@ActiveProfiles(value = {"dev"})
public class DaoTest {

    @Autowired
    private SpittlerDao spittlerDao;

    @Autowired
    private SpittlerService spittlerService;

    @Autowired
    private TemplateSpitterService templateSpitterService;

    @Autowired
    private NamedParametersSpittlerService namedParametersSpittlerService;


    @Test
    public void testJndiDao(){
        Assert.assertNotNull(spittlerDao);
        Assert.assertNotNull(spittlerService);
    }

    @Test
    public void testConnection(){
        spittlerService.getConnection();
    }

    @Test
    public void testAddSpitter(){
        Spittler spittler = new Spittler();
        spittler.setUsername("aa");
        spittler.setPassword("password");
        spittler.setFullname("xiaoMing");
        spittler.setEmail("xiaoming@gmail.com");
        spittler.setUpdateByEmail(false);
        spittlerService.addSpittler(spittler);
    }


    @Test
    public void testUpdateSpitter(){
        Spittler spittler = new Spittler();
        spittler.setUsername("abc");
        spittler.setPassword("password");
        spittler.setFullname("xiaoMing");
        spittler.setEmail("abc@gmail.com");
        spittler.setUpdateByEmail(true);
        spittlerService.updateSpittler(spittler);
    }

    @Test
    public void testFindOneSpitter(){
        Spittler  spittler = spittlerService.findOneSpittler("xiaoMing");
        System.out.println(spittler);
        Assert.assertNotNull(spittler);
    }

    @Test
    public void testTemplateSpittler(){
        Assert.assertNotNull(templateSpitterService);
        Spittler spittler = templateSpitterService.findOneSpitter("mingming");
        System.out.println(spittler);
        Assert.assertNotNull(spittler);
    }

    @Test
    public void testTemplateAddSpittler(){
        Spittler spittler = new Spittler();
        spittler.setUsername("xiaoming");
        spittler.setPassword("password");
        spittler.setFullname("mingming");
        spittler.setEmail("mingming@gmail.com");
        spittler.setUpdateByEmail(false);
        templateSpitterService.addSpitter(spittler);
    }

    /**
     * 测试labda
     */
    @Test
    public void testLabdaTemplateSpittler(){
        Assert.assertNotNull(templateSpitterService);
        Spittler spittler = templateSpitterService.lambdaFindOneSpitter("mingming");
        System.out.println(spittler);
        Assert.assertNotNull(spittler);
    }

    /**
     * 测试 methodReference
     */
    @Test
    public void testmethodReferenceTemplateSpittler(){
        Assert.assertNotNull(templateSpitterService);
        Spittler spittler = templateSpitterService.methodReferenceFindOneSpitter("mingming");
        System.out.println(spittler);
        Assert.assertNotNull(spittler);
    }


    @Test
    public void testNamedParamTemplateAddSpittler(){
        Spittler spittler = new Spittler();
        spittler.setUsername("daS");
        spittler.setPassword("password");
        spittler.setFullname("das");
        spittler.setEmail("das@gmail.com");
        spittler.setUpdateByEmail(false);
        namedParametersSpittlerService.addSpittler(spittler);
    }



}
