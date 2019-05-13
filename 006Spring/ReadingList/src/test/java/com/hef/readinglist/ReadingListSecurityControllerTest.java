package com.hef.readinglist;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


/**
 * @Date 2019-05-12
 * @Author lifei
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReadingListSecurityControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    /**
     * springSecurity() 是SecurityMockConfigurers的一个静态方法，考虑到可读性，已经静态导入
     */
    @Before
    public void setMockMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(springSecurity())
                .build();
    }

    /**
     * @WithMockUser ：加载安全上下文， 其中包含一个UserDetails， 使用了给定的用户名、密码和授权
     */
    @Test
    @WithMockUser(username = "user", password = "password", roles = "READER")
    public void homePage_authenticatedUser() throws Exception {
        mockMvc.perform(get("/readingList/user"))
                .andExpect(status().isOk())
                .andExpect(view().name("readingList"))
                .andExpect(model().attributeExists("books"))
                .andExpect(model().attribute("books", is(notNullValue())));
    }

    /**
     * 测试带有用户身份验证的安全加固方法
     * @WithUserDetails 根据给定用户名查找UserDetails对象， 加载安全上下文
     * 测试此处时， Spring 上下文中应当有 UserDetailsService
     * @throws Exception
     */
    @Test
    @WithUserDetails(value = "user")
    public void homePage_authenticatedUser02() throws Exception {
        mockMvc.perform(get("/readingList/user"))
                .andExpect(status().isOk())
                .andExpect(view().name("readingList"))
                .andExpect(model().attributeExists("books"))
                .andExpect(model().attribute("books", is(notNullValue())));
    }


}
