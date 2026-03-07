package com.patrick.orcamento.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VeiculoDTO(

        @NotBlank(message = "Modelo é obrigatório")
        String modelo,

        @NotBlank(message = "Placa é obrigatória")
        String placa,

        @NotNull(message = "Cliente é obrigatório")
        Long clienteId

) {
}
