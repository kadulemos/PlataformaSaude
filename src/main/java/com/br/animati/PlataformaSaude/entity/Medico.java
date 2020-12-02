package com.br.animati.PlataformaSaude.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter @Setter
public class Medico {

	@Id
	@GeneratedValue
	private long idMedico;
	
	private String nome;
	private UfType uf;
	private String crm;
}