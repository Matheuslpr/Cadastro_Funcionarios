package dev.java10x.Cadastro_Funcionarios.Tarefas.Service;

import dev.java10x.Cadastro_Funcionarios.Tarefas.DTO.TarefasDTO;
import dev.java10x.Cadastro_Funcionarios.Tarefas.Mapper.TarefasMapper;
import dev.java10x.Cadastro_Funcionarios.Tarefas.Model.TarefasModel;
import dev.java10x.Cadastro_Funcionarios.Tarefas.Repository.TarefasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TarefasService {

    final private TarefasRepository tarefasRepository;
    final private TarefasMapper tarefasMapper;

    public TarefasService(TarefasRepository tarefasRepository, TarefasMapper tarefasMapper) {
        this.tarefasRepository = tarefasRepository;
        this.tarefasMapper = tarefasMapper;
    }

    public List<TarefasDTO> listarTarefa(){
        List<TarefasModel> tarefas = tarefasRepository.findAll();
        return tarefas.stream()
                .map(tarefasMapper::map)
                .collect(Collectors.toList());
    }

    public TarefasDTO listarTarefaId(Long id){
        Optional<TarefasModel> tarefasId = tarefasRepository.findById(id);
        return tarefasId.map(tarefasMapper::map).orElse(null);
    }

    public TarefasDTO criarTarefa(TarefasDTO tarefasDTO){
        TarefasModel tarefas = tarefasMapper.map(tarefasDTO);
        tarefas = tarefasRepository.save(tarefas);
        return tarefasMapper.map(tarefas);
    }


    public void deletarTarefa(Long id){
        tarefasRepository.deleteById(id);
    }

    public TarefasDTO alterarTarefas(Long id, TarefasDTO tarefasDTO){
        Optional<TarefasModel> tarefaExistente = tarefasRepository.findById(id);
        if(tarefaExistente.isPresent()){
            TarefasModel tarefaAtualizada = tarefasMapper.map(tarefasDTO);
            tarefaAtualizada.setId(id);
            TarefasModel tarefaSalva = tarefasRepository.save(tarefaAtualizada);
            return tarefasMapper.map(tarefaSalva);
        }
        return null;
    }








}


