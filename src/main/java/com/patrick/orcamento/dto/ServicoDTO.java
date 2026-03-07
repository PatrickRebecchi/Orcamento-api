package com.patrick.orcamento.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record ServicoDTO(

        @NotBlank(message = "Descrição é obrigatória")
        String descricao,

        @PositiveOrZero(message = "Valor não pode ser negativo")
        double valor,

        @NotNull(message = "Orçamento é obrigatório")
        Long orcamentoId

) {}
