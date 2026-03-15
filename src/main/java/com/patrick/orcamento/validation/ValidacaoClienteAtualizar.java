package com.patrick.orcamento.validation;

import com.patrick.orcamento.dto.CadastrarClienteDTO;
import com.patrick.orcamento.entity.Cliente;


public interface ValidacaoClienteAtualizar {
    void validar(Cliente cliente, CadastrarClienteDTO dto);
}
