package com.patrick.orcamento.repository;

import com.patrick.orcamento.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
}
