package com.patrick.orcamento.service;

import com.patrick.orcamento.dto.ClienteDTO;
import com.patrick.orcamento.entity.Cliente;
import com.patrick.orcamento.exception.OrcamentoException;
import com.patrick.orcamento.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<ClienteDTO> obterTodosClientes() {
        return converteDados(repository.findAll());
    }

    public ClienteDTO obterPorId(long id) {
        Optional<Cliente> cliente = repository.findById(id);

        if (cliente.isPresent()) {
            Cliente c = cliente.get();
            return new ClienteDTO(c.getId(), c.getNome(), c.getTelefone(), c.getEmail());
        }
        throw new OrcamentoException("Série não encontrada!");
    }

    private List<ClienteDTO> converteDados(List<Cliente> clientes){
        return clientes.stream()
                .map(c -> new ClienteDTO(c.getId(), c.getNome(),c.getEmail(),c.getTelefone()))
                .collect(Collectors.toList());
    }

}
