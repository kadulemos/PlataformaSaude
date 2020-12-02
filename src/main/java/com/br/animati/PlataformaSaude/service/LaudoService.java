package com.br.animati.PlataformaSaude.service;

import java.util.List;
import java.util.Optional;

import com.br.animati.PlataformaSaude.entity.Laudo;

public interface LaudoService {

	void cadastrar(Laudo l);
	
	List<Laudo> list();
	
	void deletar(Laudo laudo);
	
	Optional<Laudo> listarPeloId(long idLaudo);
	//Optional<Medico> listarPeloIdMedico(long idMedico);
	
	void deletarPeloId(Long idLaudo);
	
}