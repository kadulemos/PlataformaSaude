package com.br.animati.PlataformaSaude.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.animati.PlataformaSaude.dao.MedicoDAO;
import com.br.animati.PlataformaSaude.entity.Medico;

@Service
public class MedicoServiceImpl implements MedicoService {
	
	@Autowired
	private MedicoDAO dao;
	
	@Override
	public void cadastrar(Medico m) {
		dao.save(m);
	}

	@Override
	public List<Medico> list() {
		return dao.findAll();
	}

	@Override
	public void deletar(Medico m) {
		dao.delete(m);
	}

	@Override
	public Optional<Medico> listarPeloId(long idMedico) {
		return dao.findById(idMedico);
	}
	
	@Override
	public void deletarPeloId(Long idMedico) {
		dao.deleteById(idMedico);
	}

}
