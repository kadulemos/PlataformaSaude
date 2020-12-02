package com.br.animati.PlataformaSaude.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.animati.PlataformaSaude.entity.Medico;

public interface MedicoDAO extends JpaRepository<Medico, Long> {

}