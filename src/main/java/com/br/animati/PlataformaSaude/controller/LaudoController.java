package com.br.animati.PlataformaSaude.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.animati.PlataformaSaude.entity.Laudo;
import com.br.animati.PlataformaSaude.service.LaudoService;

@RestController
public class LaudoController {

	@Autowired
	private LaudoService laudoService;
	
	@RequestMapping("/laudos")
	public List<Laudo> list() {
		return laudoService.list();
	}
	
	@PostMapping("/laudos")
	public void save(@RequestBody Laudo l) {
		laudoService.cadastrar(l);
	}
	
	@DeleteMapping("/laudos/{idLaudo")
	public void delete(@PathVariable long idLaudo) {
		laudoService.deletarPeloId(idLaudo);
	}
	
	@RequestMapping("/laudos/{idLaudo}")
	public Laudo listarPeloId(@PathVariable long idLaudo) {
		return laudoService.listarPeloId(idLaudo).get();
	}
}
