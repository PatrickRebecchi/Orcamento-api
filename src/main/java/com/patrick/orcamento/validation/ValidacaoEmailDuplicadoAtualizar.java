package com.patrick.orcamento.validation;

import com.patrick.orcamento.dto.CadastrarClienteDTO;
import com.patrick.orcamento.entity.Cliente;
import com.patrick.orcamento.exception.OrcamentoException;
import com.patrick.orcamento.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoEmailDuplicadoAtualizar implements ValidacaoClienteAtualizar {

    @Autowired
    private ClienteRepository repository;

    @Override
    public void validar(Cliente cliente, CadastrarClienteDTO dto) {
        if (repository.existsByEmail(dto.email()) &&
                !cliente.getEmail().equals(dto.email())) {
            throw new OrcamentoException("Email já cadastrado para outro cliente");
        }
    }
}
