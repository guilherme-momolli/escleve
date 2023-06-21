package br.edu.famapr.escleve.models;

import br.edu.famapr.escleve.models.enums.Cargo;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@Entity
@Table(name = "funcionario")
@EntityListeners(AuditingEntityListener.class)
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cpf;

    @Enumerated(EnumType.STRING)
    private Cargo cargo;

    @Column(unique = true)
    private String email;

    private String senha;

}
