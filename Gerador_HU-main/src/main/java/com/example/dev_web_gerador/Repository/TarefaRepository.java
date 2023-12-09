package com.example.dev_web_gerador.Repository;

import com.example.dev_web_gerador.Model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

}
