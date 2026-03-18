package com.patrick.orcamento.repository;

import com.patrick.orcamento.entity.Veiculo;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {


    boolean existsByPlaca(String placa);

    List<Veiculo> findByModelo(String modelo);
}
