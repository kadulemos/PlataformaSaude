package com.br.animati.PlataformaSaude.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter @Setter
public class Atendimento {
	
	@Id
	@GeneratedValue
	private long idAtendimento;
	
	private String dataHora;
	private String nomeProcedimento;
	private String modalidade;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "medico_id", nullable = false)
	private Medico medico;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "paciente_id", nullable = false)
	private Paciente paciente;
}