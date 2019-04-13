package com.hef.spittr;

import con.hef.spittr.domain.Spitter;
import con.hef.spittr.service.SpitterService;
import config.RootConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class SpitterServiceTest {

    @Autowired
    private SpitterService spitterService;

    @Test
    public void shouldNotNull(){
        Assert.assertNotNull(spitterService);
    }

    @Test
    public void testFindOneSpitter(){
        Spitter spitter = spitterService.findSpitterById(1L);
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

    private void setUpUser(String... privs){
        SecurityContext securityContext = SecurityContextHolder.getContext();
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String priv:
             privs) {
            authorities.add(new SimpleGrantedAuthority(priv));
        }
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken("spittr","spittr", authorities);
        securityContext.setAuthentication(authenticationToken);
    }
}
