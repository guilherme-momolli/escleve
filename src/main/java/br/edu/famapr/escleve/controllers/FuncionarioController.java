package br.edu.famapr.escleve.controllers;

import br.edu.famapr.escleve.models.Endereco;
import br.edu.famapr.escleve.models.Funcionario;
import br.edu.famapr.escleve.repository.EnderecoRepository;
import br.edu.famapr.escleve.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping("/hello")
    public String helloWorld() {return "Olá, mundo!";}

    @GetMapping("/list")
    public ResponseEntity<List<Object>> getAllFuncionarios(){
        try {
            return new ResponseEntity(funcionarioRepository.findAll(), HttpStatus.OK);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("add")
    public ResponseEntity<Funcionario> addFuncionario(@RequestBody Funcionario funcionario) {
        try{
            funcionario = funcionarioRepository.save(funcionario);
            return new ResponseEntity<>(funcionario, HttpStatus.CREATED);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
