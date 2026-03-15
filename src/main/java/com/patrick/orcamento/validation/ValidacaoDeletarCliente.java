package com.patrick.orcamento.validation;

import com.patrick.orcamento.dto.CadastrarClienteDTO;
import com.patrick.orcamento.exception.OrcamentoException;
import com.patrick.orcamento.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoDeletarCliente implements ValidacaoClienteDeletar {

    @Autowired
    private ClienteRepository repository;

    @Override
    public void validar(Long id) {

        if(!repository.existsById(id)){
            throw new OrcamentoException("Cliente não encontrado");
        }

    }
}
