package com.hef.spittr.web;

import com.hef.spittr.entities.Spitter;
import com.hef.spittr.service.SpitterRepository;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


public class SpitterControllerTest {

    @Test
    public void shouldShowRegisterForm() throws Exception {
        SpitterController controller = new SpitterController();

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/spitter/register"))
                .andExpect(MockMvcResultMatchers.view().name("registerForm"));
    }

    //@Test
    public void shouldProcessRegistration() throws Exception {
        SpitterRepository mockRepository = Mockito.mock(SpitterRepository.class);
        Spitter unsaved = new Spitter("XiaoMing","23hef","Wang","XiaoMing");
        Spitter saved = new Spitter(23L, "XiaoMing","23hef","Wang","XiaoMing");

        Mockito.when(mockRepository.save(unsaved)).thenReturn(saved);
        SpitterController spitterController = new SpitterController(mockRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(spitterController).build();
        mockMvc.perform(MockMvcRequestBuilders.post("/spitter/register")
                .param("firstName", "Wang")
                .param("lastName","XiaoMing")
                .param("username","XiaoMing")
                .param("password","23hef")
                ).andExpect(MockMvcResultMatchers.redirectedUrl("/spitter/XiaoMing"));
        Mockito.verify(mockRepository, Mockito.atLeastOnce()).save(unsaved);
    }
}
