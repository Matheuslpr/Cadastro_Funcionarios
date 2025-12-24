package dev.java10x.Cadastro_Funcionarios.Funcionarios.Service;

import dev.java10x.Cadastro_Funcionarios.Funcionarios.DTO.FuncionariosDTO;
import dev.java10x.Cadastro_Funcionarios.Funcionarios.Mapper.FuncionariosMapper;
import dev.java10x.Cadastro_Funcionarios.Funcionarios.Model.FuncionariosModel;
import dev.java10x.Cadastro_Funcionarios.Funcionarios.Repository.FuncionariosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionariosService {

    final private FuncionariosRepository funcionariosRepository;
    final  private FuncionariosMapper funcionariosMapper;

    public FuncionariosService(FuncionariosRepository funcionariosRepository, FuncionariosMapper funcionariosMapper) {
        this.funcionariosRepository = funcionariosRepository;
        this.funcionariosMapper = funcionariosMapper;
    }


    public List<FuncionariosDTO> listarFuncionarios(){
        List<FuncionariosModel> funcionarios = funcionariosRepository.findAll();
        return funcionarios.stream()
                .map(funcionariosMapper::map)
                .collect(Collectors.toList());
    }


    public FuncionariosDTO listarFuncionariosId(Long id){
        Optional<FuncionariosModel> funcionariosId = funcionariosRepository.findById(id);
        return funcionariosId.map(funcionariosMapper::map).orElse(null);
    }


    public FuncionariosDTO criarFuncionario(FuncionariosDTO funcionario){
        FuncionariosModel funcionarios = funcionariosMapper.map(funcionario);
        funcionarios = funcionariosRepository.save(funcionarios);
        return funcionariosMapper.map(funcionarios);
    }


    public void deletarFuncionario(Long id){
        funcionariosRepository.deleteById(id);
    }


    public FuncionariosDTO alterarFuncionarios(Long id, FuncionariosDTO funcionario){
        Optional<FuncionariosModel> funcionarioExistente = funcionariosRepository.findById(id);
        if(funcionarioExistente.isPresent()){
            FuncionariosModel funcionarioAtualizado = funcionariosMapper.map(funcionario);
            funcionarioAtualizado.setId(id);
            FuncionariosModel funcionarioSalvo = funcionariosRepository.save(funcionarioAtualizado);
            return funcionariosMapper.map(funcionarioSalvo);
        }
        return null;
    }


}
