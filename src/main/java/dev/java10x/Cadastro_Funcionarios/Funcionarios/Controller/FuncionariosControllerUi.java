package dev.java10x.Cadastro_Funcionarios.Funcionarios.Controller;

import dev.java10x.Cadastro_Funcionarios.Funcionarios.DTO.FuncionariosDTO;
import dev.java10x.Cadastro_Funcionarios.Funcionarios.Service.FuncionariosService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/funcionarios/ui")
public class FuncionariosControllerUi {

    final private FuncionariosService funcionariosService;

    public FuncionariosControllerUi(FuncionariosService funcionariosService) {
        this.funcionariosService = funcionariosService;
    }


    @GetMapping("/listar")
    public String listarFuncionarios(Model model){
        List<FuncionariosDTO> funcionarios = funcionariosService.listarFuncionarios();
        model.addAttribute("funcionarios", funcionarios);
        return "listarFuncionario";
    }


    @GetMapping("/listar/{id}")
    public String listarFuncionariosId(@PathVariable Long id, Model model){
        FuncionariosDTO funcionariosId = funcionariosService.listarFuncionariosId(id);
        if(funcionariosId != null){
            model.addAttribute("funcionarios", funcionariosId);
            return "detalhesFuncionario";
        }else {
            model.addAttribute("mensagem", "Funcionario não encontrado");
            return "listarFuncionario";
        }
    }


    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionarFuncionarios(Model model) {
        model.addAttribute("funcionarios", new FuncionariosDTO());
        return "adicionarFuncionario";
    }


    @DeleteMapping("/deletar/{id}")
    public String deletarFuncionario(@PathVariable Long id){
            funcionariosService.deletarFuncionario(id);
            return "redirect:/funcionarios/ui/listar";
    }

    @GetMapping("/alterar/{id}")
    public String editarFuncionarioFormulario(@PathVariable Long id, Model model) {


        FuncionariosDTO funcionario = funcionariosService.listarFuncionariosId(id);

        if (funcionario == null) {
            return "redirect:/funcionarios/ui?error=notfound";
        }

        model.addAttribute("funcionario", funcionario);

        return "listarFuncionario";
    }


    @PostMapping("/salvar")
    public String salvarFuncionarios(@ModelAttribute FuncionariosDTO funcionario, RedirectAttributes redirectAttributes) {
        funcionariosService.criarFuncionario(funcionario);
        redirectAttributes.addFlashAttribute("mensagem", "Funcionario cadastrado com sucesso!");
        return "redirect:/funcionarios/ui/listar";
    }

}
