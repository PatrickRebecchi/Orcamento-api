package com.patrick.orcamento.controller;


import com.patrick.orcamento.dto.CadastrarClienteDTO;
import com.patrick.orcamento.dto.ClienteDTO;
import com.patrick.orcamento.repository.ClienteRepository;
import com.patrick.orcamento.service.ClienteService;
import jakarta.validation.Valid;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping()
    public List<ClienteDTO> obterTodosClientes(){
        return service.obterTodosClientes();
    }
    @GetMapping("/{id}")
    public ClienteDTO buscarPorId(@PathVariable long id){
        return service.obterPorId(id);
    }


    @PostMapping()                                              // Objeto(CadastrarClienteDTO) -- Parametro(dto) service
    public CadastrarClienteDTO cadastrarCliente(@RequestBody @Valid CadastrarClienteDTO dto){
        return this.service.cadastrar(dto);
    }

    @PutMapping("/{id}")
    public CadastrarClienteDTO alterarCadastroCliente(@PathVariable Long id, @RequestBody CadastrarClienteDTO dto) {
        return service.atualizarDados(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deletar(@PathVariable long id){
        service.deletarCliente(id);
        return ResponseEntity.ok(Map.of("Mensagem", "Cliente deletado com sucesso"));
    }

}
