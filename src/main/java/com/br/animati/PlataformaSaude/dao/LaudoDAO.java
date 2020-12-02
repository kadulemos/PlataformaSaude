package com.br.animati.PlataformaSaude.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.animati.PlataformaSaude.entity.Laudo;

@Repository
public interface LaudoDAO extends JpaRepository<Laudo, Long> {
	
}