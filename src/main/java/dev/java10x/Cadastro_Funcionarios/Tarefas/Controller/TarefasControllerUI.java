package dev.java10x.Cadastro_Funcionarios.Tarefas.Controller;

import dev.java10x.Cadastro_Funcionarios.Tarefas.DTO.TarefasDTO;
import dev.java10x.Cadastro_Funcionarios.Tarefas.Service.TarefasService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/tarefas/ui")
public class TarefasControllerUI {

    private final TarefasService tarefasService;

    public TarefasControllerUI(TarefasService tarefasService) {
        this.tarefasService = tarefasService;
    }


    @GetMapping("/listar")
    public String listarTarefa(Model model){
        List<TarefasDTO> tarefas = tarefasService.listarTarefa();
        model.addAttribute("tarefas", tarefas);
        return "listartarefas";
    }


    @GetMapping("/listar/{id}")
    public String listarTarefaId(@PathVariable Long id, Model model){
        TarefasDTO tarefasId = tarefasService.listarTarefaId(id);
        if(tarefasId != null){
            model.addAttribute("tarefas", tarefasId);
            return "detalhestarefas";
        }else {
            model.addAttribute("mensagem", "Tarefas não encontrada");
            return "listartarefas";
        }
    }


    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionartarefas(Model model) {
        model.addAttribute("tarefas", new TarefasDTO());
        return "adicionartarefas";
    }


    @DeleteMapping("/deletar/{id}")
    public String deletarTarefa(@PathVariable Long id){
        tarefasService.deletarTarefa(id);
        return "redirect:/tarefas/ui/listar";
    }

    @PostMapping("/salvar")
    public String salvarTarefa(@ModelAttribute TarefasDTO tarefa, RedirectAttributes redirectAttributes) {
        tarefasService.criarTarefa(tarefa);
        redirectAttributes.addFlashAttribute("mensagem", "Tarefa cadastrada com sucesso!");
        return "redirect:/tarefas/ui/listar";
    }
}
