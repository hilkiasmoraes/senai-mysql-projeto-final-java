package com.moraes.senai.Interface;

import com.moraes.senai.Model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno,Long> {
}