package com.hef.spittr;

import con.hef.spittr.domain.Spitter;
import con.hef.spittr.service.SpitterService;
import config.RootConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class SpitterServiceTest {

    @Autowired
    private SpitterService spitterService;

    @Before
    public void clearContext(){
        SecurityContextHolder.clearContext();
    }
    @Test
    public void shouldNotNull(){
        Assert.assertNotNull(spitterService);
    }

    @Test
    public void testFindOneSpitter(){
        // 设置权限
        setUpUser("ROLE_SPITTER");

        Spitter spitter = spitterService.findSpitterById(1L);
        System.out.println(spitter);
        Assert.assertNotNull(spitter);
    }
    @Test
    public void testFindOneSpitterById(){
        // 设置权限
        setUpUser("ROLE_SPITTLER");

        Spitter spitter = spitterService.findOneSpitterById(14L);
        System.out.println(spitter);
        Assert.assertNotNull(spitter);
    }

    @Test
    public void testSaveSpitter(){
        //设置权限
        setUpUser("ROLE_ADMIN");

        Spitter spitter = new Spitter("apple", "applePhone",
                "password","apple@Gmail.com",false);
        Spitter sp = spitterService.saveSpitter(spitter);
        System.out.println(sp);
        Assert.assertNotNull(sp.getId());
    }

    @Test
    public void testDeleteSpitter(){
        spitterService.deleteSpitter(20L);
    }

    @Test
    public void testDeleteOneSpitter(){
        //设置权限
        setUpUser("ROLE_SPITTER");

        spitterService.deleteOneSpitter(22L);
    }

    @Test
    public void addSpitterTest(){
        //设置权限
        setUpUser("ROLE_ADMIN");

        Spitter spitter = new Spitter("pro authorize", "authorize",
                "password","pro@Gmail.com",false);
        Spitter sp = spitterService.addSpitter(spitter);
        System.out.println(sp);
        Assert.assertNotNull(sp.getId());
    }

    @Test
    public void findAllTest(){
        //设置权限
        setUpUser("ROLE_ADMIN");
        List<Spitter> spitters = spitterService.findAllSpitter();
        for (Spitter s:
                spitters) {
            System.out.println(s);
        }
    }

    @Test
    public void saveSpitters(){
        //设置权限
        setUpUser("ROLE_ADMIN");

        Spitter spitter =null;
        List<Spitter> spitters = new ArrayList<>();
        spitter = new Spitter("spitters", "spitters",
                "password","spitters@Gmail.com",true);
        spitters.add(spitter);
        List<Spitter> li = spitterService.addSppiters(spitters);
        for (Spitter s:
             li) {
            System.out.println(s);
        }
    }

    /**
     * 如果要删除的用户名 和 权限用户名称相同 可以删除
     * 或者 admin权限用户可以删除
     */
    @Test
    public void deleteSpittersTest(){

        //设置权限
        setUpUser("ROLE_ADMIN");


        List<Spitter> list = new ArrayList<>();
        list.add(spitterService.findSpitterById(15L));
//        list.add(spitterService.findSpitterById(14L));
        spitterService.deleteSpitters(list);
    }



    private void setUpUser(String... privs){
        SecurityContext securityContext = SecurityContextHolder.getContext();
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String priv:
                privs) {
            authorities.add(new SimpleGrantedAuthority(priv));

        }
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken("hong","spittr", authorities);
        System.out.println("***");
        System.out.println(authenticationToken.getPrincipal().getClass());
        System.out.println("***");
        securityContext.setAuthentication(authenticationToken);

        String name = securityContext.getAuthentication().getName();
        System.out.println(name);
    }


}
