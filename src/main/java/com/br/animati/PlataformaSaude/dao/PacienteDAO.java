package com.br.animati.PlataformaSaude.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.animati.PlataformaSaude.entity.Paciente;

@Repository
public interface PacienteDAO extends JpaRepository<Paciente, Long>{

}