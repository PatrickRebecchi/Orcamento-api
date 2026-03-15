package com.patrick.orcamento.service;

import com.patrick.orcamento.dto.CadastrarClienteDTO;
import com.patrick.orcamento.dto.ClienteDTO;
import com.patrick.orcamento.entity.Cliente;
import com.patrick.orcamento.exception.OrcamentoException;
import com.patrick.orcamento.repository.ClienteRepository;

import com.patrick.orcamento.validation.ValidacaoCadastrarCliente;
import com.patrick.orcamento.validation.ValidacaoDeletarCliente;
import com.patrick.orcamento.validation.ValidacaoEmailDuplicadoAtualizar;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;
    @Autowired
    private List<ValidacaoCadastrarCliente> validacao;
    @Autowired
    private List<ValidacaoDeletarCliente> validacaoDeletarClientes;
    @Autowired
    private  List<ValidacaoEmailDuplicadoAtualizar> validacaoAtualizarCliente;


    @Transactional
    public List<ClienteDTO> obterTodosClientes() {
        return converteDados(repository.findAll());
    }

    @Transactional
    public ClienteDTO obterPorId(long id) {
        Cliente c = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        return new ClienteDTO(
                c.getId(),
                c.getNome(),
                c.getTelefone(),
                c.getEmail());
    }

    private List<ClienteDTO> converteDados(List<Cliente> clientes) {
        return clientes.stream()
                .map(c -> new ClienteDTO(
                        c.getId(),
                        c.getNome(),
                        c.getTelefone(),
                        c.getEmail()))
                .collect(Collectors.toList());
    }
                                            // Parametro(dto) -  tipo (CadastrarClienteDTO)
    // public CadastrarClienteDTO cadastrar(CadastrarClienteDTO  dto)

    @Transactional
    public CadastrarClienteDTO cadastrar(CadastrarClienteDTO dto) {

        Cliente cliente = new Cliente(dto);
        validacao.forEach(c -> c.validar(dto));

        cliente = repository.save(cliente);
        return new CadastrarClienteDTO(cliente.getNome(), cliente.getTelefone(), cliente.getEmail());

    }

    @Transactional
    public CadastrarClienteDTO atualizarDados(Long id, CadastrarClienteDTO dto) {

        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new OrcamentoException("Cliente não encontrado"));

        validacaoAtualizarCliente.forEach(c -> c.validar(cliente, dto));

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
        validacaoDeletarClientes.forEach(d-> d.validar(id));
        repository.deleteById(id);
    }
}
