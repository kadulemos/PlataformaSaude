package com.br.animati.PlataformaSaude.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.animati.PlataformaSaude.dao.LaudoDAO;
import com.br.animati.PlataformaSaude.entity.Laudo;

@Service
public class LaudoServiceImpl implements LaudoService {
	
	@Autowired
	private LaudoDAO dao;

	@Override
	public void cadastrar(Laudo l) {
		dao.save(l);

	}

	@Override
	public List<Laudo> list() {
		return dao.findAll();
	}
	
	@Override
	public void deletar(Laudo laudo) {
		dao.delete(laudo);
		
	}

	@Override
	public Optional<Laudo> listarPeloId(long idLaudo) {
		return Optional.ofNullable(dao.findById(idLaudo).get());
	}
	
	/*
	@Override
	public Optional<Medico> listarPeloIdMedico(long idMedico) {
		return dao.;
	}
	*/

	@Override
	public void deletarPeloId(Long idLaudo) {
		dao.deleteById(idLaudo);
		
	}

}