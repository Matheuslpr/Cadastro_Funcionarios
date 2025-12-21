package dev.java10x.Cadastro_Funcionarios.Funcionarios.Model;

import dev.java10x.Cadastro_Funcionarios.Tarefas.Model.TarefasModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//TABELA
@Entity
@Table(name = "tb_funcionarios")

//CONSTRUTORES
@NoArgsConstructor
@AllArgsConstructor

//GETTERS E SETTERS
@Data

//ToString
@ToString(exclude = "tarefas")

public class FuncionariosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column (name = "img_url")
    private String imgUrl;
    @Column(name = "nome")
    private String nome;
    @Column(unique=true)
    private String email;
    @Column(name = "cargo")
    private String cargo;


    @ManyToOne
    @JoinColumn(name = "tarefas_id")
    private TarefasModel tarefas;
}
