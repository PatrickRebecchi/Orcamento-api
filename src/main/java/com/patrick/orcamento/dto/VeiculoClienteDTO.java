package com.patrick.orcamento.dto;

public record VeiculoClienteDTO(Long id,
                                String modelo,
                                String placa,
                                Long clienteId,
                                String nomeCliente,
                                String emailCliente) {}
