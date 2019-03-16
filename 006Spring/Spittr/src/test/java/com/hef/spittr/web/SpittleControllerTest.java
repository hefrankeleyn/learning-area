package com.hef.spittr.web;

import com.hef.spittr.entities.Spittle;
import com.hef.spittr.service.SpittleRepository;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpittleControllerTest {


    @Test
    public void shouldShowRecentSpittles() throws Exception {
        List<Spittle> expectedSpittles = createSpittleList(20);
        // 创建一个给定类或接口的mock对象，
        SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);   // MOck Repository
        Mockito.when(mockRepository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedSpittles);

        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)    // Mock Spring MVC
                .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
                .build();

        mockMvc.perform(MockMvcRequestBuilders.get("/spittles")) // 对"/spittles"发起GET请求
                .andExpect(MockMvcResultMatchers.view().name("spittles")) // 断言期望的视图名
                .andExpect(MockMvcResultMatchers.model().attributeExists("spittleList"))  // 断言期望的model的key值
                .andExpect(MockMvcResultMatchers.model().attribute("spittleList", Matchers.hasItems(expectedSpittles.toArray())));   // 断言期望的值
    }

    @Test
    public void shouldShowPagedSpittles() throws Exception {
        List<Spittle> expectedSpittles = createSpittleList(50);
        // 创建一个给定类或接口的mock对象，
        SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);   // MOck Repository
        Mockito.when(mockRepository.findSpittles(100, 50)).thenReturn(expectedSpittles);

        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)    // Mock Spring MVC
                .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
                .build();

        mockMvc.perform(MockMvcRequestBuilders.get("/spittles?max=100&count=50")) // 对"/spittles"发起GET请求
                .andExpect(MockMvcResultMatchers.view().name("spittles")) // 断言期望的视图名
                .andExpect(MockMvcResultMatchers.model().attributeExists("spittleList"))  // 断言期望的model的key值
                .andExpect(MockMvcResultMatchers.model().attribute("spittleList",
                        Matchers.hasItems(expectedSpittles.toArray())));   // 断言期望的值
    }

    @Test
    public void testSpittle() throws Exception {
        Spittle expectSpittle = new Spittle("Hello", new Date());
        SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);
        Mockito.when(mockRepository.findOne(2)).thenReturn(expectSpittle);

        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/spittles/2")) // 对"/spittles"发起GET请求
                .andExpect(MockMvcResultMatchers.view().name("spittle")) // 断言期望的视图名
                .andExpect(MockMvcResultMatchers.model().attributeExists("spittle"))  // 断言期望的model的key值
                .andExpect(MockMvcResultMatchers.model().attribute("spittle",
                        expectSpittle));   // 断言期望的值

    }


    private List<Spittle> createSpittleList(int count){
        List<Spittle> spittles = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle"+i,new Date()));
        }
        return spittles;
    }
}
