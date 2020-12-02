package com.br.animati.PlataformaSaude.service;

import java.util.List;
import java.util.Optional;

import com.br.animati.PlataformaSaude.entity.Paciente;

public interface PacienteService {
	
	void cadastrar(Paciente p);
	List<Paciente> list();
	void deletar(Paciente p);
	Optional<Paciente> listarPeloId(long idPaciente);
	void deletarPeloId(Long idPaciente);

}
