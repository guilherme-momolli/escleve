package br.edu.famapr.escleve.controllers;

import br.edu.famapr.escleve.dto.LoginRequestDTO;
import br.edu.famapr.escleve.models.Funcionario;
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

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDTO request) {
        String login = request.getLogin();
        String senha = request.getSenha();

        boolean autenticado = autenticar(login, senha);

        if (autenticado) {
            return ResponseEntity.ok("Login bem-sucedido!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
        }
    }

    public boolean autenticar(String email, String senha) {
        Funcionario funcionario = funcionarioRepository.findByEmail(email);
        if (funcionario != null) {

            return senha.equals(funcionario.getSenha());

        }
        return false;
    }

}
