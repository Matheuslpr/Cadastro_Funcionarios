package dev.java10x.Cadastro_Funcionarios.Funcionarios.DTO;

import dev.java10x.Cadastro_Funcionarios.Tarefas.Model.TarefasModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//CONSTRUTORES
@NoArgsConstructor
@AllArgsConstructor

//GETTERS E SETTERS
@Data

public class FuncionariosDTO {

    private Long id;
    private String imgUrl;
    private String nome;
    private String email;
    private String cargo;
    private TarefasModel tarefas;
}
