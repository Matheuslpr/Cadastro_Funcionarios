package dev.java10x.Cadastro_Funcionarios.Funcionarios.Mapper;

import dev.java10x.Cadastro_Funcionarios.Funcionarios.DTO.FuncionariosDTO;
import dev.java10x.Cadastro_Funcionarios.Funcionarios.Model.FuncionariosModel;
import org.springframework.stereotype.Component;


@Component
public class FuncionariosMapper {

    public FuncionariosModel map(FuncionariosDTO funcionariosDTO){

        FuncionariosModel funcionariosModel = new FuncionariosModel();
        funcionariosModel.setId(funcionariosDTO.getId());
        funcionariosModel.setImgUrl(funcionariosDTO.getImgUrl());
        funcionariosModel.setNome(funcionariosDTO.getNome());
        funcionariosModel.setEmail(funcionariosDTO.getEmail());
        funcionariosModel.setCargo(funcionariosDTO.getCargo());
        funcionariosModel.setTarefas(funcionariosDTO.getTarefas());

        return funcionariosModel;
    }
    public  FuncionariosDTO map (FuncionariosModel funcionariosModel){

        FuncionariosDTO funcionariosDTO = new FuncionariosDTO();
        funcionariosDTO.setId(funcionariosDTO.getId());
        funcionariosDTO.setImgUrl(funcionariosDTO.getImgUrl());
        funcionariosDTO.setNome(funcionariosDTO.getNome());
        funcionariosDTO.setEmail(funcionariosDTO.getEmail());
        funcionariosDTO.setCargo(funcionariosDTO.getCargo());
        funcionariosDTO.setTarefas(funcionariosDTO.getTarefas());

        return funcionariosDTO;
    }
}
