package com.example.simplejava.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AddController.class)
class AddControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAddReturnsSum() throws Exception {
        mockMvc.perform(get("/add")
                .param("a", "2")
                .param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.sum", is(5)));
    }

    @Test
    void postAddReturnsSum() throws Exception {
        String json = "{\"a\":4,\"b\":6}";
        mockMvc.perform(post("/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.sum", is(10)));
    }
}