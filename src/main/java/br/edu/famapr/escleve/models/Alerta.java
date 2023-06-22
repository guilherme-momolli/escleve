package br.edu.famapr.escleve.models;

import br.edu.famapr.escleve.models.enums.Emergencia;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "alerta")
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Emergencia emergencia;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime data_ocorrencia;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario emissor;
}
