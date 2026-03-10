package com.patrick.orcamento.controller;


import com.patrick.orcamento.dto.ClienteDTO;
import com.patrick.orcamento.dto.VeiculoClienteDTO;
import com.patrick.orcamento.dto.VeiculoDTO;
import com.patrick.orcamento.entity.Cliente;
import com.patrick.orcamento.entity.Veiculo;
import com.patrick.orcamento.service.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService service;

    @GetMapping
    public List<VeiculoClienteDTO> listar(){
        return service.listar();
    }

    @PostMapping
    public VeiculoDTO cadastrar(@Valid @RequestBody VeiculoDTO dto){
        return service.cadastrar(dto);
    }


}
