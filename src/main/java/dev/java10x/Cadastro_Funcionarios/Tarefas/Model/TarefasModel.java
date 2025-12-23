package dev.java10x.Cadastro_Funcionarios.Tarefas.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.Cadastro_Funcionarios.Funcionarios.Model.FuncionariosModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

//TABELA
@Entity
@Table(name = "tb_tarefas")

//CONSTRUTORES
@NoArgsConstructor
@AllArgsConstructor

//GETTERS E SETTERS
@Data

//ToString
@ToString


public class TarefasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "descricao")
    private String descricao;

    @OneToMany(mappedBy = "tarefas")
    @JsonIgnore
    List<FuncionariosModel> funcionarios;
}
