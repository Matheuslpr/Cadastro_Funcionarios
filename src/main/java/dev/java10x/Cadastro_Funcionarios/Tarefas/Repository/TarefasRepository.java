package dev.java10x.Cadastro_Funcionarios.Tarefas.Repository;

import dev.java10x.Cadastro_Funcionarios.Tarefas.Model.TarefasModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefasRepository extends JpaRepository<TarefasModel, Long> {
}
