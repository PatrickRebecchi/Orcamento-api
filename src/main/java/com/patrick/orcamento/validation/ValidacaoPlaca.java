package com.patrick.orcamento.validation;

import com.patrick.orcamento.dto.VeiculoClienteDTO;
import com.patrick.orcamento.dto.VeiculoDTO;
import com.patrick.orcamento.entity.Veiculo;
import com.patrick.orcamento.exception.OrcamentoException;
import com.patrick.orcamento.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoPlaca {

    @Autowired
    private VeiculoRepository repository;

    public void validar(VeiculoDTO dto){
        if(repository.existsByPlaca(dto.placa())){
            throw new OrcamentoException("placa já cadastrada");
        }
    }
}
