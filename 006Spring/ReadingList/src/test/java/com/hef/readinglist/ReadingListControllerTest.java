package com.hef.readinglist;

import static org.hamcrest.Matchers.*;

import com.hef.readinglist.domain.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @Date 2019-05-11
 * @Author lifei
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReadingListControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setupMockMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .build();
    }

    /**
     * 测试 HTTP 发送GET请求
     * @throws Exception
     */
    @Test
    public void homePage() throws Exception {
        mockMvc.perform(get("/readingList/user"))
                .andExpect(status().isOk())
                .andExpect(view().name("readingList"))
                .andExpect(model().attributeExists("books"))
                .andExpect(model().attribute("books", is(notNullValue())));
    }

    @Test
    public void postBook() throws Exception {
        mockMvc.perform(post("/readingList/user")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("reader", "user")
                        .param("isbn","456")
                        .param("title", "MySql")
                        .param("author", "xiaoMing")
                        .param("description", "dream"))
                .andExpect(status().is3xxRedirection())
                .andExpect(header().string("Location", "/readingList/user"));

        /*Book expectedBook = new Book();
        expectedBook.setId(6l);
        expectedBook.setReader("user");
        expectedBook.setTitle("MySql");
        expectedBook.setAuthor("xiaoMing");
        expectedBook.setDescription("dream");

        mockMvc.perform(get("/readingList/user"))
                .andExpect(status().isOk())
                .andExpect(view().name("readingList"))
                .andExpect(model().attributeExists("books"))
                .andExpect(model().attribute("books", hasSize(6)));*/
//                .andExpect(model().attribute("books", contains(samePropertyValuesAs(expectedBook))));


    }


}
