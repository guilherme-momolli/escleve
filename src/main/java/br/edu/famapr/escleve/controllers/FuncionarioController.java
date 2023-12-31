package br.edu.famapr.escleve.controllers;

import br.edu.famapr.escleve.dto.LoginRequestDTO;
import br.edu.famapr.escleve.models.Funcionario;
import br.edu.famapr.escleve.models.Instituicao;
import br.edu.famapr.escleve.repository.FuncionarioRepository;
import br.edu.famapr.escleve.repository.InstituicaoRepository;
import org.hibernate.sql.exec.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private InstituicaoRepository instituicaoRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

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

//    @PostMapping("/add")
//    public ResponseEntity<Funcionario> addFuncionario(@RequestBody Funcionario funcionario) {
//        try{
//
//            funcionario.setSenha(passwordEncoder.encode(funcionario.getSenha()));
//            funcionario = funcionarioRepository.save(funcionario);
//            return new ResponseEntity<>(funcionario, HttpStatus.CREATED);
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//        }
//    }

    @PostMapping("/add/{instituicaoId}")
    public ResponseEntity<String> cadastrarFuncionario(
            @PathVariable Long instituicaoId,
            @RequestBody Funcionario funcionario) {

        Optional<Instituicao> optionalInstituicao = instituicaoRepository.findById(instituicaoId);
        if (optionalInstituicao.isEmpty()) {
            throw new ExecutionException("Instituição não encontrada com o ID: " + instituicaoId);
        }

        Instituicao instituicao = optionalInstituicao.get();
        funcionario.setInstituicao(instituicao);
        instituicao.getFuncionarios().add(funcionario);

        instituicaoRepository.save(instituicao);

        return ResponseEntity.ok("Usuário Cadastrado!");
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
            return passwordEncoder.matches(senha, funcionario.getSenha());
        }
        return false;
    }

}
