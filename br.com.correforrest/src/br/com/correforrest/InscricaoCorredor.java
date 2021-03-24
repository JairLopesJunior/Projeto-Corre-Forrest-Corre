package br.com.correforrest;

import enums.NumeroCamiseta;
import enums.OpcaoProva;
import enums.SituacaoInscricao;

public class InscricaoCorredor {

	private String nome;
	private String cpf;
	private String numeroInscricao;
	private NumeroCamiseta numeroCamiseta;
	private OpcaoProva opcao;
	private SituacaoInscricao situacaoInscricao;
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setNumeroInscricao(String numeroInscricao) {
		this.numeroInscricao = numeroInscricao;
	}
	public void setNumeroCamiseta(NumeroCamiseta numeroCamiseta) {
		this.numeroCamiseta = numeroCamiseta;
	}
	public void setOpcao(OpcaoProva opcao) {
		this.opcao = opcao;
	}
	public void setSituacaoInscricao(SituacaoInscricao situacaoInscricao) {
		this.situacaoInscricao = situacaoInscricao;
	}
	
	
	
}
