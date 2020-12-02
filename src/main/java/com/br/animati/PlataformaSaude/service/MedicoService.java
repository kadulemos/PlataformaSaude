package com.br.animati.PlataformaSaude.service;

import java.util.List;
import java.util.Optional;

import com.br.animati.PlataformaSaude.entity.Medico;

public interface MedicoService {

	void cadastrar(Medico m) throws Exception;
	List<Medico> list();
	void deletar(Medico m);
	Optional<Medico> listarPeloId(long idMedico);
	void deletarPeloId(Long idMedico);
}