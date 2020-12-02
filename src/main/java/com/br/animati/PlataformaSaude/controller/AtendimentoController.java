package com.br.animati.PlataformaSaude.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.animati.PlataformaSaude.entity.Atendimento;
import com.br.animati.PlataformaSaude.service.AtendimentoService;

@RestController
public class AtendimentoController {

	@Autowired
	private AtendimentoService atendimentoService;
	
	@RequestMapping("/atendimentos")
	public List<Atendimento> list() {
		return atendimentoService.list();
	}
	
	@PostMapping("/atendimentos")
	public void save(@RequestBody Atendimento at) {
		atendimentoService.cadastrar(at);
	}
	
	@RequestMapping("/atendimentos/{idAtendimento}")
	public Atendimento findById(@PathVariable long idAtentimento) {
		return atendimentoService.listarPeloId(idAtentimento).get();
	}
	
	@DeleteMapping("/atendimentos/{idAtendimento}")
	public void delete(@PathVariable long idAtendimento) {
		atendimentoService.deletarPeloId(idAtendimento);
	}
	
	@PutMapping ("/atendimentos/{idAtendimento}")
	public void update(@PathVariable long idAtendimento, @RequestBody Atendimento newAtendimento) {
		Optional<Atendimento> oldAtendimento = atendimentoService.listarPeloId(idAtendimento);
		if (oldAtendimento.isPresent()) {
			Atendimento atendimento = oldAtendimento.get();
			atendimento.setDataHora(newAtendimento.getDataHora());
			atendimento.setNomeProcedimento(newAtendimento.getNomeProcedimento());
			atendimento.setModalidade(newAtendimento.getModalidade());
			atendimento.setMedico(newAtendimento.getMedico());
			atendimento.setPaciente(newAtendimento.getPaciente());
			
			atendimentoService.cadastrar(atendimento);
		}
	}
	
}
