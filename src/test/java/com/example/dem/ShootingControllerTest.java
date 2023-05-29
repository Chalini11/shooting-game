package com.example.dem;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
@WebMvcTest(ShootingController.class)
public class ShootingControllerTest {
    @MockBean
    private ShootingService shootingService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldGetHealthOfHero () throws Exception{

        Mockito.when(shootingService.getHealth(1)).thenReturn(100);
        mockMvc.perform(MockMvcRequestBuilders.get("/health?who=1"))
                .andExpect(status().isOk()).andExpect(content().json(objectMapper.writeValueAsString(100)));
    }

    @Test
    void shouldGetHealthOfVillain () throws Exception{

        Mockito.when(shootingService.getHealth(2)).thenReturn(100);
        mockMvc.perform(MockMvcRequestBuilders.get("/health?who=2"))
                .andExpect(status().isOk()).andExpect(content().string(String.valueOf(100)));
    }

    @Test // Hero shoots villain . Post API invoked
    void shouldCheckShootingVillain () throws Exception{

       // Mockito.when(shootingService.getHealth(2)).thenReturn(100); Instead we need to verify
        mockMvc.perform(MockMvcRequestBuilders.post("/shootDamage?who=villain"))
                .andExpect(status().is(201));
        // how to print ?? toAdd(print)
    }

    @Test // Villain shoots Hero
    void shouldCheckShootingHero () throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.post("/shootDamage?who=hero"))
                .andExpect(status().is(201));
    }

    @Test
    void shouldToggleArmourOfVillain () throws Exception{

        // from web to program
        mockMvc.perform(MockMvcRequestBuilders.post("/armour"))
                .andExpect(status().is(201));
    }

}
