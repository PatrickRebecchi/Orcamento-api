package com.patrick.orcamento.validation;

import com.patrick.orcamento.dto.CadastrarClienteDTO;
import com.patrick.orcamento.dto.OrcamentoDTO;
import com.patrick.orcamento.exception.OrcamentoException;
import com.patrick.orcamento.repository.ClienteRepository;
import com.patrick.orcamento.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoCadastrarCliente implements ValidacaoClienteoCadastrar {
    @Autowired
    private ClienteRepository repository;

    @Override
    public void validar(CadastrarClienteDTO dto) {
        if(repository.existsByEmail(dto.email())){
            throw new OrcamentoException("Email já cadastrado");
        }
    }
}
