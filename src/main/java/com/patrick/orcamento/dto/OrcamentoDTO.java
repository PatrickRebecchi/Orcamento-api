package com.patrick.orcamento.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record OrcamentoDTO(
        Long id,
        LocalDateTime data,
        String status,
        @NotNull(message = "Veículo é obrigatório")
        Long veiculoId

) {}
