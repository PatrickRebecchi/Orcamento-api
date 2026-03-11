package com.patrick.orcamento.service;

import com.patrick.orcamento.dto.CadastrarClienteDTO;
import com.patrick.orcamento.dto.ClienteDTO;
import com.patrick.orcamento.entity.Cliente;
import com.patrick.orcamento.exception.OrcamentoException;
import com.patrick.orcamento.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Transactional
    public List<ClienteDTO> obterTodosClientes() {
        return converteDados(repository.findAll());
    }

    @Transactional
    public ClienteDTO obterPorId(long id) {
        Optional<Cliente> cliente = repository.findById(id);

        if (cliente.isPresent()) {
            Cliente c = cliente.get();
            return new ClienteDTO(c.getId(), c.getNome(), c.getTelefone(), c.getEmail());
        }
        throw new OrcamentoException("Cliente não encontrada!");
    }

    private List<ClienteDTO> converteDados(List<Cliente> clientes) {
        return clientes.stream()
                .map(c -> new ClienteDTO(c.getId(), c.getNome(), c.getEmail(), c.getTelefone()))
                .collect(Collectors.toList());
    }
                                            // Parametro(dto) -  tipo (CadastrarClienteDTO)
    // public CadastrarClienteDTO cadastrar(CadastrarClienteDTO  dto)

    @Transactional
    public CadastrarClienteDTO cadastrar(CadastrarClienteDTO dto) {
        Cliente cliente = new Cliente(dto);
        if(repository.existsByEmail(dto.email())){
            throw new OrcamentoException("Email já cadastrado");
        }
        cliente = repository.save(cliente);
        return new CadastrarClienteDTO(cliente.getNome(), cliente.getTelefone(), cliente.getEmail());

    }

    @Transactional
    public CadastrarClienteDTO atualizarDados(Long id, CadastrarClienteDTO dto) {

        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new OrcamentoException("Cliente não encontradoPut!"));

        cliente.setNome(dto.nome());
        cliente.setTelefone(dto.telefone());
        cliente.setEmail(dto.email());

        return new CadastrarClienteDTO(
                cliente.getNome(),
                cliente.getTelefone(),
                cliente.getEmail()
        );
    }

    @Transactional
    public void deletarCliente(long id) {
        if (!repository.existsById(id)){
            throw new OrcamentoException("Cliente não encontradoDelete");
        }
        repository.deleteById(id);
    }
}
