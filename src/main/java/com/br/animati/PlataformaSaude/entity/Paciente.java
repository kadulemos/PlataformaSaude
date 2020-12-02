package com.br.animati.PlataformaSaude.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
@Entity
public class Paciente {

	@Id
	@GeneratedValue
	private long idPaciente;
	
	private String empresa;
	private String nome;
	private String nomeSocial;
	private String nomeMae;
	private UfType uf;
	private String cpf;
	private String password;
	private String rg;
	private SexType sexo;

}