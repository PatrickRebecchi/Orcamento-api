package com.patrick.orcamento.dto;

import jakarta.validation.constraints.NotNull;

public record OrcamentoDTO(

        @NotNull(message = "Veículo é obrigatório")
        Long veiculoId

) {}
