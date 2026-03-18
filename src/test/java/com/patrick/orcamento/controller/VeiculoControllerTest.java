package com.patrick.orcamento.controller;

import com.patrick.orcamento.service.VeiculoService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Disabled
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class VeiculoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void buscarPorModelo_deveRetornar400_quandoModeloInvalido() throws Exception{

        mockMvc.perform(get("/veiculos/modelo/ "))
                .andExpect(status().isBadRequest());

    }

    @Test
    void listarTodosVeiculos_deveRetornar200() throws Exception{

        mockMvc.perform(get("/veiculos"))
                .andExpect(status().isOk());

    }
}