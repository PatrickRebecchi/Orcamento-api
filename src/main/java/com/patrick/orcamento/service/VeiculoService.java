package com.patrick.orcamento.service;

import com.patrick.orcamento.dto.VeiculoClienteDTO;
import com.patrick.orcamento.dto.VeiculoDTO;
import com.patrick.orcamento.entity.Cliente;
import com.patrick.orcamento.entity.Veiculo;
import com.patrick.orcamento.exception.OrcamentoException;
import com.patrick.orcamento.repository.ClienteRepository;
import com.patrick.orcamento.repository.VeiculoRepository;
import com.patrick.orcamento.validation.ValidacaoPlaca;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository repository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private List<ValidacaoPlaca> validacao;
    
    @Transactional
    public VeiculoDTO cadastrar(VeiculoDTO dto) {

        Cliente cliente = clienteRepository.findById(dto.clienteId())
                .orElseThrow(() -> new OrcamentoException("Cliente não encontrado"));

        validacao.forEach(v -> v.validar(dto));

         Veiculo v = new Veiculo();
         v.setModelo(dto.modelo());
         v.setPlaca(dto.placa());
         v.setCliente(cliente);

        repository.save(v);
        return new VeiculoDTO(v.getModelo(), v.getPlaca(),v.getCliente().getId());

    }

    public List<VeiculoClienteDTO> listar() {
        return converteDados(repository.findAll());

    }


    private List<VeiculoClienteDTO> converteDados(List<Veiculo> veiculos) {
        return veiculos.stream()
                .map(v -> new VeiculoClienteDTO(v.getId(), v.getModelo(), v.getPlaca(),
                v.getCliente().getId(),
                v.getCliente().getNome(),
                v.getCliente().getEmail()))
                .collect(Collectors.toList());
    }
}
