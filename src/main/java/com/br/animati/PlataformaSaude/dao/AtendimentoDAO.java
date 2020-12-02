package com.br.animati.PlataformaSaude.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.animati.PlataformaSaude.entity.Atendimento;

@Repository
public interface AtendimentoDAO extends JpaRepository<Atendimento, Long> {

}