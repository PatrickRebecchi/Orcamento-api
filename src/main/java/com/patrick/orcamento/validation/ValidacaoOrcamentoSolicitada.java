package com.patrick.orcamento.validation;

import com.patrick.orcamento.dto.OrcamentoDTO;
import com.patrick.orcamento.dto.VeiculoDTO;

public interface ValidacaoOrcamentoSolicitada {

    void validar(OrcamentoDTO dto);
}
