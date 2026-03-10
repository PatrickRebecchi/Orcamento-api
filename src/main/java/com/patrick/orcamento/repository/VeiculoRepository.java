package com.patrick.orcamento.repository;

import com.patrick.orcamento.entity.Veiculo;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {


    boolean existsByPlaca(String placa);
}
