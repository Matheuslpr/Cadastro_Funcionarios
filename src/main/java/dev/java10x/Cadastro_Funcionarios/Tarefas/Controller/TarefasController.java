package dev.java10x.Cadastro_Funcionarios.Tarefas.Controller;

import dev.java10x.Cadastro_Funcionarios.Tarefas.DTO.TarefasDTO;
import dev.java10x.Cadastro_Funcionarios.Tarefas.Model.TarefasModel;
import dev.java10x.Cadastro_Funcionarios.Tarefas.Service.TarefasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefasController {

    final private TarefasService tarefasService;

    public TarefasController(TarefasService tarefasService) {
        this.tarefasService = tarefasService;
    }


    @PostMapping("/criar")
    public ResponseEntity<String> criarTarefa(@RequestBody TarefasDTO tarefasDTO){
        TarefasDTO novaTarefa = tarefasService.criarTarefa(tarefasDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Tarefa criada com sucesso: " + novaTarefa.getTitulo() + (" ID") + novaTarefa.getId());
    }


    @GetMapping("/listar")
    public ResponseEntity<List<TarefasDTO>> listarTarefa(){
        List<TarefasDTO> tarefas = tarefasService.listarTarefa();
        return ResponseEntity.ok(tarefas);
    }


    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarTarefaId(@PathVariable Long id) {
        TarefasDTO tarefasId = tarefasService.listarTarefaId(id);
        if (tarefasId != null) {
            return ResponseEntity.ok(tarefasId);
        }else {
          return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                  .body("Tarefa com ID: " + id + " não existe em nosso sistema");
        }
    }


    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarTarefa(@PathVariable Long id, @RequestBody TarefasDTO tarefaAtualiizada){

        TarefasDTO tarefasDTO = tarefasService.alterarTarefas(id, tarefaAtualiizada);
        if (tarefasDTO != null){
            return ResponseEntity.ok(tarefasDTO);
        }else {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Tarefa com ID: " + id + " não existe em nosso sistema");
        }
    }


    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarTarefa(@PathVariable Long id){
        if (tarefasService.listarTarefaId(id) != null){
            tarefasService.deletarTarefa(id);
            return ResponseEntity.ok("Tarefa com ID: " + id + " deletada com sucesso");
        }else {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Tarefa com ID: " + id + " não existe em nosso sistema");
        }
    }
}
