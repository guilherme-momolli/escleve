package br.edu.famapr.escleve.controllers;

import br.edu.famapr.escleve.models.Endereco;
import br.edu.famapr.escleve.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping("/hello")
    public String helloWorld() {return "Olá, mundo!";}
    @GetMapping("/list")
    public ResponseEntity<List<Object>> getAllEnderecos(){
        try {
            return new ResponseEntity(enderecoRepository.findAll(), HttpStatus.OK);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/add")
    public ResponseEntity<Endereco> addEndereco(@RequestBody Endereco endereco) {
        try{
            endereco = enderecoRepository.save(endereco);
            return new ResponseEntity<>(endereco, HttpStatus.CREATED);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
