package com.patrick.orcamento.service;

import com.patrick.orcamento.dto.*;
import com.patrick.orcamento.entity.Orcamento;
import com.patrick.orcamento.entity.Status;
import com.patrick.orcamento.entity.Veiculo;
import com.patrick.orcamento.exception.OrcamentoException;
import com.patrick.orcamento.repository.OrcamentoRepository;
import com.patrick.orcamento.repository.VeiculoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrcamentoService {

    @Autowired
    private OrcamentoRepository repository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<OrcamentoDTO> listar() {
        return converteDados(repository.findAll());
    }

    public List<OrcamentoClienteDTO> listarCompleto() {
        return converteDadosCliente(repository.findAll());
    }

    @Transactional
    public OrcamentoDTO cadastrar(OrcamentoDTO dto) {

        Veiculo veiculo = veiculoRepository.findById(dto.veiculoId())
                        .orElseThrow(() -> new OrcamentoException("Veiculo não encontrado"));

        Orcamento o = new Orcamento();
        o.setData(dto.data());
        o.setStatus(Status.ABERTO);
        o.setVeiculo(veiculo);

        repository.save(o);

        return new OrcamentoDTO(
                o.getData(),
                o.getStatus().name(),
                o.getVeiculo().getId());
    }

    private List<OrcamentoDTO> converteDados(List<Orcamento> orcamentos){
        return orcamentos.stream()
                .map(o -> new OrcamentoDTO(o.getData(),
                        o.getStatus().name(),
                        o.getVeiculo().getId()))
                .collect(Collectors.toList());
    }

    @Transactional
    public void aprovar(Long id){
        Orcamento orcamento = repository.findById(id)
                .orElseThrow(() -> new OrcamentoException("Orçamento não encontrado"));
        orcamento.setStatus(Status.APROVADO);
    }

    public void finalizar(Long id) {
        Orcamento orcamento = repository.findById(id)
                .orElseThrow(()-> new OrcamentoException("Orçamento não encontrado"));
        orcamento.setStatus(Status.FINALIZADO);
    }

    private List<OrcamentoClienteDTO> converteDadosCliente(List<Orcamento> orcamentos) {
        return orcamentos.stream()
                .map(o -> new OrcamentoClienteDTO(
                        o.getData(),
                        o.getStatus().name(),
                        o.getVeiculo().getId(),
                        o.getVeiculo().getModelo(),
                        o.getVeiculo().getPlaca(),
                        o.getVeiculo().getCliente().getId(),
                        o.getVeiculo().getCliente().getNome(),
                        o.getVeiculo().getCliente().getEmail()))
                .collect(Collectors.toList());
    }
}
