package br.com.correforrest;

import enums.NumeroCamiseta;
import enums.OpcaoProva;
import enums.SituacaoInscricao;

public class InscricaoCorredor {

	private String nome;
	private String cpf;
	private Integer numeroInscricao;
	private NumeroCamiseta numeroCamiseta;
	private OpcaoProva opcao;
	private SituacaoInscricao situacaoInscricao;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public NumeroCamiseta getNumeroCamiseta() {
		return numeroCamiseta;
	}
	public void setNumeroCamiseta(NumeroCamiseta numeroCamiseta) {
		this.numeroCamiseta = numeroCamiseta;
	}
	public OpcaoProva getOpcao() {
		return opcao;
	}
	public void setOpcao(OpcaoProva opcao) {
		this.opcao = opcao;
	}
	public SituacaoInscricao getSituacaoInscricao() {
		return situacaoInscricao;
	}
	public void setSituacaoInscricao(SituacaoInscricao situacaoInscricao) {
		this.situacaoInscricao = situacaoInscricao;
	}
	public void setNumeroInscricao(Integer numeroInscricao) {
		this.numeroInscricao = numeroInscricao;
	}
	
	
}
