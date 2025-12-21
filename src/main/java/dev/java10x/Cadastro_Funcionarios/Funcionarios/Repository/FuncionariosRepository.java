package dev.java10x.Cadastro_Funcionarios.Funcionarios.Repository;

import dev.java10x.Cadastro_Funcionarios.Funcionarios.Model.FuncionariosModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionariosRepository extends JpaRepository<FuncionariosModel, Long> {
}
