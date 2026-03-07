package com.patrick.orcamento.repository;

import com.patrick.orcamento.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
