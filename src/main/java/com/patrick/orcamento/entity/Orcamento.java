package com.patrick.orcamento.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orcamentos")
public class Orcamento {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    private LocalDateTime data;
    @Enumerated(EnumType.STRING)
    private Status status = Status.ABERTO;

    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;

    @OneToMany(mappedBy = "orcamento", cascade = CascadeType.ALL)
    private List<Servico> servicos;
}
