package br.edu.famapr.escleve.models;

import br.edu.famapr.escleve.models.enums.UF;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@Entity
@Table(name = "endereco")
@EntityListeners(AuditingEntityListener.class)
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UF estado;

    private String cidade;

    private String cep;

    private String bairro;

    private String rua;

    private String numero;
}
