package br.edu.famapr.escleve.models;

import br.edu.famapr.escleve.models.enums.Cargo;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "instituicao")
public class Instituicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String nucleo;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

}
