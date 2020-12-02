package com.br.animati.PlataformaSaude.entity;

public enum SexType {
	M("Masculino"),
	F("Feminino");
	
	private String descricao;
	
	SexType(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}