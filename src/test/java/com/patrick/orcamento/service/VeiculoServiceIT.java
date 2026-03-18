package com.patrick.orcamento.service;

import com.patrick.orcamento.dto.VeiculoClienteDTO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Disabled
@SpringBootTest
@ActiveProfiles("test")
class VeiculoServiceIT {

    @Autowired
    private VeiculoService service;

    @Test
    void deveBuscarVeiculosJaSalvosNoBancoVariosVeiculos() {

        List<VeiculoClienteDTO> resultado =
                service.obterPorModelo("Hb20"); //  valor REAL do banco

        assertEquals(2, resultado.size());
        assertTrue(
                resultado.stream()
                        .allMatch(V -> V.modelo().equals("Hb20"))
        );
    }

    @Test
    void deveBuscarVeiculosJaSalvosNoBanco() {

        List<VeiculoClienteDTO> resultado =
                service.obterPorModelo("Hb20"); //  valor REAL do banco

        assertNotNull(resultado);

       assertFalse(resultado.isEmpty());
        VeiculoClienteDTO dto = resultado.get(0); // aqui eu busco o primeiro hb20 do banco de dados

        //assertEquals("Hb20", dto.modelo()); //  mesmo valor esperado
        assertTrue(
                resultado.stream()
                        .allMatch(V -> V.modelo().equals("Hb20"))
        );
    }


}