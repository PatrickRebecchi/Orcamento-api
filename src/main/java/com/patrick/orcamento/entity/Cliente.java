package com.patrick.orcamento.entity;

import com.patrick.orcamento.dto.CadastrarClienteDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    private String telefone;

    @Email(message = "Por favor, insira um e-mail válido")
    @NotBlank(message = "O e-mail não pode estar vazio")
    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "cliente", cascade= CascadeType.ALL)
    private List<Veiculo> veiculos;

    public Cliente(CadastrarClienteDTO dto){
        this.nome = dto.nome();
        this.telefone = dto.telefone();
        this.email = dto.email();
    }


}
