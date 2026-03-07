package com.patrick.orcamento.service;


import com.patrick.orcamento.dto.ClienteDTO;
import com.patrick.orcamento.entity.Cliente;
import com.patrick.orcamento.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {
    @Mock
    private ClienteRepository repository;

    @InjectMocks
    private ClienteService service;

    @Test
    void deveRetornarClienteQuandoIdExiste(){
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("Patrick");
        cliente.setEmail("patrickrebecchi@hotmail.com");
        cliente.setTelefone("11959195906");

        when(repository.findById(1L)).thenReturn(Optional.of(cliente));

        ClienteDTO resultado = service.obterPorId(1L);

        assertNotNull(resultado);
        assertEquals("Patrick",resultado.nome());
    }
}