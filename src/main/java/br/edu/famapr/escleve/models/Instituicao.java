package br.edu.famapr.escleve.models;

import br.edu.famapr.escleve.models.enums.Cargo;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "instituicao")
public class Instituicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String nucleo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @OneToMany(mappedBy = "instituicao", cascade = CascadeType.ALL)
    private List<Funcionario> funcionarios = new ArrayList<>();
}
