package com.patrick.orcamento.service;

import com.patrick.orcamento.repository.OrcamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrcamentoService {

    @Autowired
    private OrcamentoRepository repository;

}
