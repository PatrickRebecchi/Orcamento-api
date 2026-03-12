package com.patrick.orcamento.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record OrcamentoClienteDTO(

        LocalDateTime data,
        String status,
        Long veiculoId,
        String modelo,
        String placa,
        Long clienteId,
        String nomeCliente,
        String emailCliente)
{}
