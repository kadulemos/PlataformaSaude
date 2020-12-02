package com.br.animati.PlataformaSaude.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoutersController {
	
	
	@GetMapping("/index")
	public String pacienteIndex() {
		return "/index";
	}
	
	@GetMapping("/pages/atendimentos")
	public String atendimentoIndex() {
		return "/pages/atendimentos";
	}
	
	@GetMapping("/pages/laudos")
	public String laudoIndex() {
		return "/pages/laudos";
	}
	
	@GetMapping("/pages/medicos")
	public String medicoIndex() {
		return "/pages/medicos";
	}

}