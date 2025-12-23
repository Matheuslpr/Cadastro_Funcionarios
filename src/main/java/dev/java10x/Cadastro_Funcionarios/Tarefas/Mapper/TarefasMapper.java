package dev.java10x.Cadastro_Funcionarios.Tarefas.Mapper;

import dev.java10x.Cadastro_Funcionarios.Tarefas.DTO.TarefasDTO;
import dev.java10x.Cadastro_Funcionarios.Tarefas.Model.TarefasModel;
import org.springframework.stereotype.Component;

@Component
public class TarefasMapper {

    public TarefasModel map(TarefasDTO tarefasDTO){

        TarefasModel tarefasModel = new TarefasModel();
        tarefasModel.setId(tarefasDTO.getId());
        tarefasModel.setTitulo(tarefasDTO.getTitulo());
        tarefasModel.setDescricao(tarefasDTO.getDescricao());
        tarefasModel.setFuncionarios(tarefasDTO.getFuncionarios());

        return tarefasModel;
    }

    public TarefasDTO map(TarefasModel tarefasModel){

        TarefasDTO tarefasDTO = new TarefasDTO();
        tarefasDTO.setId(tarefasDTO.getId());
        tarefasDTO.setTitulo(tarefasDTO.getTitulo());
        tarefasDTO.setDescricao(tarefasDTO.getDescricao());
        tarefasDTO.setFuncionarios(tarefasDTO.getFuncionarios());

        return tarefasDTO;
    }
}
