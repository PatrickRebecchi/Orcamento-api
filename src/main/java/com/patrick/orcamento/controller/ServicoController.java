package com.patrick.orcamento.controller;


import com.patrick.orcamento.service.ClienteService;
import com.patrick.orcamento.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servico")
public class ServicoController {

    @Autowired
    private ServicoService service;
}
