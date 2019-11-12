package com.improving.bootcamp;

import org.improving.bootcamp.SimpleController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@WebMvcTest(controllers = SimpleController.class)
public class SimpleControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Test
    public void test() throws Exception {
        mockMvc.perform(get("/home")).
                andExpect(MockMvcResultMatchers.view().name("home"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("The Great Gatsby"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("book"));

    }
}
