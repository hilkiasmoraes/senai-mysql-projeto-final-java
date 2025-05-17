package com.moraes.senai.Controller;

import com.moraes.senai.Model.Aluno;
import com.moraes.senai.Service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public List<Aluno> listaDeAlunos(){
        return alunoService.buscarAlunos();
    }

    @GetMapping("/id")
    public Aluno buscarAlunoPorId(@PathVariable Long id){
        return alunoService.buscarAlunoId(id);
    }

    @PostMapping
    public Aluno criarAluno(@RequestBody Aluno aluno){
        return alunoService.salvarAluno(aluno);
    }

    @PutMapping
    public Aluno atualizarAluno(@PathVariable Long id, @RequestBody Aluno alunoAlterado){
        Aluno verificaAluno = alunoService.buscarAlunoId(id);
        if (verificaAluno == null) return null;
        verificaAluno.setNomeAluno(alunoAlterado.getNomeAluno());
        verificaAluno.setEmailAluno(alunoAlterado.getEmailAluno());
        verificaAluno.setTelefoneAluno(alunoAlterado.getTelefoneAluno());
        return alunoService.salvarAluno(alunoAlterado);
    }

    @DeleteMapping("/id")
    public void deletarAluno(@PathVariable Long id){
        alunoService.excluirAluno(id);
    }
}