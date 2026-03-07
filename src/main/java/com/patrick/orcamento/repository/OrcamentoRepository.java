package com.patrick.orcamento.repository;

import com.patrick.orcamento.entity.Orcamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrcamentoRepository extends JpaRepository<Orcamento, Long> {
}
