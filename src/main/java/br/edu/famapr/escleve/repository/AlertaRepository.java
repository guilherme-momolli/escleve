package br.edu.famapr.escleve.repository;

import br.edu.famapr.escleve.models.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface AlertaRepository extends JpaRepository<Alerta, Long> {

    ArrayList<Alerta> findAll();
    Alerta save(Alerta alerta);
    Optional<Alerta> findById(Long id);

}
