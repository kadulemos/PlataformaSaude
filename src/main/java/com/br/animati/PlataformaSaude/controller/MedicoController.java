package com.br.animati.PlataformaSaude.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.animati.PlataformaSaude.entity.Medico;
import com.br.animati.PlataformaSaude.service.MedicoService;

@RestController
public class MedicoController {

	@Autowired
	private MedicoService medicoService;
	
	@RequestMapping("/medicos")
	public List<Medico> list() {
		return medicoService.list();
	}
	
	@PostMapping("/medicos")
	public void save(@RequestBody Medico m) throws Exception {
		medicoService.cadastrar(m);
	}
	
	@RequestMapping("/medicos/{idMedico}")
	public Optional<Medico> findById(@PathVariable long idMedico) {
		return medicoService.listarPeloId(idMedico);
	}
	
}