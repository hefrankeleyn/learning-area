package com.hef.readinglist;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Date 2019-05-08
 * @Author lifei
 */
public class PasswordTest {

    @Test
    public void encoder(){
        String password = "hellow";
        BCryptPasswordEncoder en = new BCryptPasswordEncoder();
        String rePassword = en.encode(password);
        System.out.println(rePassword);

    }
}
