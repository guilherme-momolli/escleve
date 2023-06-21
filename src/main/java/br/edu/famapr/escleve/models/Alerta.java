package br.edu.famapr.escleve.models;

import br.edu.famapr.escleve.models.enums.Emergencia;
import jakarta.persistence.*;
import java.time.LocalDateTime;

public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Emergencia emergencia;

    private LocalDateTime data_ocorrencia;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario emissor;
}
