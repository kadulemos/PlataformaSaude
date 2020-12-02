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
	
	@DeleteMapping("/medicos/{idMedico}")
	public void delete(@PathVariable long idMedico) {
		medicoService.deletarPeloId(idMedico);
	}
	
	@PutMapping ("/medico/{idMedico}")
	public void update(@PathVariable long idMedico, @RequestBody Medico newMedico) throws Exception {
		Optional<Medico> oldMedico = medicoService.listarPeloId(idMedico);
		if (oldMedico.isPresent()) {
			Medico medico = oldMedico.get();
			medico.setNome(newMedico.getNome());
			medico.setCrm(newMedico.getCrm());
			
			medicoService.cadastrar(medico);
		}
	}
	
}