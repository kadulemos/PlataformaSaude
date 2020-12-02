package com.br.animati.PlataformaSaude.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.animati.PlataformaSaude.dao.AtendimentoDAO;
import com.br.animati.PlataformaSaude.entity.Atendimento;

@Service
public class AtendimentoServiceImpl implements AtendimentoService {
	
	@Autowired
	private AtendimentoDAO dao;

	@Override
	public void cadastrar(Atendimento at) {
		dao.save(at);

	}

	@Override
	public List<Atendimento> list() {
		return dao.findAll();
	}

	@Override
	public void deletar(Atendimento at) {
		dao.delete(at);

	}
	
	@Override
	public Optional<Atendimento> listarPeloId(long idAtendimento) {
		return dao.findById(idAtendimento);
	}
	
	@Override
	public void deletarPeloId(Long idAtendimento) {
		dao.deleteById(idAtendimento);
	}

}