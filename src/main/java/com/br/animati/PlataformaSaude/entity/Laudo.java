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
public class Laudo {
	
	@Id
	@GeneratedValue
	private long idLaudo;
	
	private String texto;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "atendimento_id", nullable = false)
	private Atendimento atendimento;

}