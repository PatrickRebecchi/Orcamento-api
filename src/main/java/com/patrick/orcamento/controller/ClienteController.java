package com.patrick.orcamento.controller;


import com.patrick.orcamento.dto.ClienteDTO;
import com.patrick.orcamento.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping()
    public List<ClienteDTO> obterTodosClientes(){
        return service.obterTodosClientes();
    }
}
