package com.patrick.orcamento.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClienteDTO(@NotBlank(message = "Nome é obrigatório")
                         String nome,
                         String telefone,
                         @Email(message = "Email inválido")
                         @NotBlank(message = "Email é obrigatório")
                         String email) {
}
