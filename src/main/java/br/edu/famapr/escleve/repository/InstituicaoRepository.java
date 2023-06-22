package br.edu.famapr.escleve.repository;

import br.edu.famapr.escleve.models.Instituicao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface InstituicaoRepository extends JpaRepository<Instituicao, Long> {
    ArrayList<Instituicao> findAll();
    Instituicao save(Instituicao instituicao);
    Optional<Instituicao> findById(Long id);

}
