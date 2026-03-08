package com.patrick.orcamento.controller;


import com.patrick.orcamento.dto.CadastrarClienteDTO;
import com.patrick.orcamento.dto.ClienteDTO;
import com.patrick.orcamento.service.ClienteService;
import jakarta.validation.Valid;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping()
    public List<ClienteDTO> obterTodosClientes(){
        return service.obterTodosClientes();
    }

    @PostMapping()
    public CadastrarClienteDTO cadastrarCliente(@RequestBody @Valid CadastrarClienteDTO dto){
        return this.service.cadastrar(dto);
    }


}
