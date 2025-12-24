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
        funcionariosDTO.setId(funcionariosModel.getId());
        funcionariosDTO.setImgUrl(funcionariosModel.getImgUrl());
        funcionariosDTO.setNome(funcionariosModel.getNome());
        funcionariosDTO.setEmail(funcionariosModel.getEmail());
        funcionariosDTO.setCargo(funcionariosModel.getCargo());
        funcionariosDTO.setTarefas(funcionariosModel.getTarefas());

        return funcionariosDTO;
    }
}
