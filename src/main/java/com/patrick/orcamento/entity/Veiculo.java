package com.patrick.orcamento.entity;

import com.patrick.orcamento.OrcamentoApplication;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "veiculos")
public class Veiculo {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "modelo é obrigatório")
    private String modelo;
    private String placa;


    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "veiculo", cascade = CascadeType.ALL)
    private List<Orcamento> orcamentos;


}
