package com.patrick.orcamento.controller;


import com.patrick.orcamento.dto.OrcamentoDTO;
import com.patrick.orcamento.dto.VeiculoDTO;
import com.patrick.orcamento.exception.OrcamentoException;
import com.patrick.orcamento.service.OrcamentoService;
import jakarta.validation.Valid;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orcamento")
public class OrcamentoController {

    @Autowired
    private OrcamentoService service;

    @GetMapping
    public List<OrcamentoDTO> orçamentos(){
        return service.listar();
    }

    @PostMapping
    public OrcamentoDTO cadastrar(@Valid @RequestBody OrcamentoDTO dto){
        return service.cadastrar(dto);
    }

    @PatchMapping("/{id}/aprovar")
    public ResponseEntity<String> aprovar(@PathVariable Long id){
        service.aprovar(id);
        return ResponseEntity.ok("Orçamento aprovado com sucesso");
    }

    @PatchMapping("/{id}/finalizado")
    public ResponseEntity<String> finalizar(@PathVariable Long id){
        service.finalizar(id);
        //return ResponseEntity.ok("Orçamento finalizado");
        return ResponseEntity.ok("Orçamento finalizado com sucesso");
    }
}
