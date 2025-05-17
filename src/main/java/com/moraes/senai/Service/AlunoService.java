package com.moraes.senai.Service;

import com.moraes.senai.Interface.AlunoRepository;
import com.moraes.senai.Model.Aluno;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> buscarAlunos(){
        return alunoRepository.findAll();
    }

    public Aluno salvarAluno(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    public void excluirAluno(Long id){
        alunoRepository.deleteById(id);
    }

    public Aluno buscarAlunoId(Long id){
        return alunoRepository.findById(id).orElse(null);
    }
}