package com.br.animati.PlataformaSaude.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.animati.PlataformaSaude.dao.PacienteDAO;
import com.br.animati.PlataformaSaude.entity.Paciente;

@Service
public class PacienteServiceImpl implements PacienteService {
	
	@Autowired
	private PacienteDAO dao;

	@Override
	public void cadastrar(Paciente p) {
		dao.save(p);

	}

	@Override
	public List<Paciente> list() {
		return dao.findAll();
	}

	@Override
	public void deletar(Paciente p) {
		dao.delete(p);

	}
	
	@Override
	public Optional<Paciente> listarPeloId(long idPaciente) {
		return dao.findById(idPaciente);
	}

	@Override
	public void deletarPeloId(Long idPaciente) {
		dao.deleteById(idPaciente);
	}

}