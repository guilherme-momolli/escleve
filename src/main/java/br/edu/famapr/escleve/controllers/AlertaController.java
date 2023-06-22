package br.edu.famapr.escleve.controllers;

import br.edu.famapr.escleve.models.Alerta;
import br.edu.famapr.escleve.repository.AlertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/alerta")
public class AlertaController {

    @Autowired
    private AlertaRepository alertaRepository;

    @GetMapping("/list")
    public ResponseEntity<List<Object>> getAllAlertas(){
        try {
            return new ResponseEntity(alertaRepository.findAll(), HttpStatus.OK);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Alerta> addAlerta(@RequestBody Alerta alerta) {
        try{
            alerta.setData_ocorrencia(LocalDateTime.now());
            alerta = alertaRepository.save(alerta);
            return new ResponseEntity<>(alerta, HttpStatus.CREATED);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
