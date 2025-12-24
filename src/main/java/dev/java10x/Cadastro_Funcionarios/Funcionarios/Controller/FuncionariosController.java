package dev.java10x.Cadastro_Funcionarios.Funcionarios.Controller;

import dev.java10x.Cadastro_Funcionarios.Funcionarios.DTO.FuncionariosDTO;
import dev.java10x.Cadastro_Funcionarios.Funcionarios.Service.FuncionariosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionariosController {


    final private FuncionariosService funcionariosService;

    public FuncionariosController(FuncionariosService funcionariosService) {
        this.funcionariosService = funcionariosService;
    }


    @PostMapping("/criar")
    public ResponseEntity<String> criarFuncionario(@RequestBody FuncionariosDTO funcionario){
        FuncionariosDTO novoFuncionaio = funcionariosService.criarFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Funcionario criado com sucesso: " + novoFuncionaio.getNome() + (" ID") + novoFuncionaio.getId());
    }



    @GetMapping("/listar")
    public ResponseEntity<List<FuncionariosDTO>> listarFuncionarios(){
        List<FuncionariosDTO> funcionarios = funcionariosService.listarFuncionarios();
        return ResponseEntity.ok(funcionarios) ;
    }


    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarFuncionariosId(@PathVariable Long id){
        FuncionariosDTO funcionariosId = funcionariosService.listarFuncionariosId(id);
        if(funcionariosId != null){
            return ResponseEntity.ok(funcionariosId);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Funcionario com ID: " + id + " não existe em nosso sistema");
        }
    }


    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarFincionarios(@PathVariable Long id, @RequestBody FuncionariosDTO funcionarioAtualizado){
        FuncionariosDTO funcionario = funcionariosService.alterarFuncionarios(id, funcionarioAtualizado);
        if(funcionario != null){
            return ResponseEntity.ok(funcionario);
        } else {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Funcionario com ID: " + id + " não existe em nosso sistema");
        }

    }


    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarFuncionario(@PathVariable Long id){
        if (funcionariosService.listarFuncionariosId(id) != null){
            funcionariosService.deletarFuncionario(id);
            return ResponseEntity.ok("Funcionario com ID " + id + " deletado com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não foi possivel encontrar Funcionario com ID: " + id);

        }
    }


}

