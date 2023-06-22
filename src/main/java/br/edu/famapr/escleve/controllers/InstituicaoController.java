package br.edu.famapr.escleve.controllers;

import br.edu.famapr.escleve.models.Instituicao;
import br.edu.famapr.escleve.repository.InstituicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instituicao")
public class InstituicaoController {

    @Autowired
    private InstituicaoRepository instituicaoRepository;

    @GetMapping("/hello")
    public String helloWorld() {return "Olá, mundo!";}

    @GetMapping("/list")
    public ResponseEntity<List<Object>> getAllInstituicao(){
        try {
            return new ResponseEntity(instituicaoRepository.findAll(), HttpStatus.OK);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/add")
    public ResponseEntity<Instituicao> addInstituicao(@RequestBody Instituicao instituicao) {
        try{
            instituicao = instituicaoRepository.save(instituicao);
            return new ResponseEntity<>(instituicao, HttpStatus.CREATED);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


}
