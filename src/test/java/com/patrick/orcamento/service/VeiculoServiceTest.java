package com.patrick.orcamento.service;

import com.patrick.orcamento.dto.VeiculoClienteDTO;
import com.patrick.orcamento.entity.Cliente;
import com.patrick.orcamento.entity.Veiculo;
import com.patrick.orcamento.repository.VeiculoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VeiculoServiceTest {

    @Test
    void cadastrar() {
    }
    @Mock
    private VeiculoRepository repository;

    @InjectMocks
    private VeiculoService service;

    @Test
    void listar() {

        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("Patrick");
        cliente.setEmail("patrickrebecchi@hotmail.com");
        cliente.setTelefone("11959195906");

        Veiculo veiculo = new Veiculo();
        veiculo.setId(1L);
        veiculo.setModelo("Hb20");
        veiculo.setPlaca("tes0t01");
        veiculo.setCliente(cliente);


        when(repository.findById(1L)).thenReturn(Optional.of(veiculo));

            VeiculoClienteDTO resultado = service.obterPorId(1L);

        assertNotNull(resultado);
        assertEquals("Hb20",resultado.modelo());   // aqui o modelo desejavel seja Hb20. Se for diferente disso, o teste deve falhar.
        assertEquals("Debora",resultado.nomeCliente());


    }
}