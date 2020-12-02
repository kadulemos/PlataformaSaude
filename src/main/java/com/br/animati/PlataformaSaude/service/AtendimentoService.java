package com.br.animati.PlataformaSaude.service;

import java.util.List;
import java.util.Optional;

import com.br.animati.PlataformaSaude.entity.Atendimento;

public interface AtendimentoService {

	void cadastrar(Atendimento at);
	List<Atendimento> list();
	void deletar(Atendimento at);
	Optional<Atendimento> listarPeloId(long idAtendimento);
	void deletarPeloId(Long idAtendimento);
	
}