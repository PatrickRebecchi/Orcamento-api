package com.patrick.orcamento.validation;

import com.patrick.orcamento.dto.OrcamentoDTO;
import com.patrick.orcamento.exception.OrcamentoException;
import com.patrick.orcamento.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoCadastrarOrcamento implements ValidacaoOrcamentoSolicitada {
    @Autowired
    private VeiculoRepository repository;

    @Override
    public void validar(OrcamentoDTO dto) {
        if (!repository.existsById(dto.veiculoId())) {
            throw new OrcamentoException("Veículo não encontrado");
        }
    }
}
