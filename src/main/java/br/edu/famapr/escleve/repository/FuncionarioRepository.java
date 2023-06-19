package br.edu.famapr.escleve.repository;

import br.edu.famapr.escleve.models.Endereco;
import br.edu.famapr.escleve.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface FuncionarioRepository  extends JpaRepository<Funcionario, Long> {

    ArrayList<Funcionario> findAll();
    Funcionario save(Funcionario funcionario);
    Optional<Funcionario> findById(Long id);

}
