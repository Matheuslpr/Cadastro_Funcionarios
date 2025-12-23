package dev.java10x.Cadastro_Funcionarios.Tarefas.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.Cadastro_Funcionarios.Funcionarios.Model.FuncionariosModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//CONSTRUTORES
@NoArgsConstructor
@AllArgsConstructor

//GETTERS E SETTERS
@Data

public class TarefasDTO {

    private Long id;
    private String titulo;
    private String descricao;
    @JsonIgnore
    List<FuncionariosModel> funcionarios;

}
