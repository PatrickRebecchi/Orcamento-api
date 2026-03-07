package com.patrick.orcamento.service;

import com.patrick.orcamento.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ClienteService {

    @Autowired
    private ClienteRepository repository;
}
