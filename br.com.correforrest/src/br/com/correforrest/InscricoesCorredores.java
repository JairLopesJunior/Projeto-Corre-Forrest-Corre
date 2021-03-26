package br.com.correforrest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import enums.NumeroCamiseta;
import enums.OpcaoProva;
import enums.SituacaoInscricao;

public class InscricoesCorredores {
	
	Scanner scan = new Scanner(System.in);
		
	List<InscricaoCorredor> inscricoes = new ArrayList<>();
	
	// Opção 1 - Realizar Inscrição
	public void adicionar(InscricaoCorredor inscricao) {	
		
		Integer i = 1;
		System.out.println("Informe seu nome: ");
		String nome = scan.next();
		inscricao.setNome(nome);
		
		System.out.println("Informe seu CPF: ");
		String cpf = scan.next();
		inscricao.setCpf(cpf);

		inscricao.setNumeroInscricao(i++);
		System.out.println("Informe o numero da Camiseta: Ex: 1. P, 2. M, 3. G, 4. GG, 5. XG e 6. XGG.");
		Integer camiseta = scan.nextInt();
		NumeroCamiseta camisetaEscolhida = whatCamiseta(camiseta);
		inscricao.setNumeroCamiseta(camisetaEscolhida);
		
		System.out.println("Informe a prova: Ex: 1. Kids, 2. Caminhada_5K, 3. Corrida_5K, 4. Corrida_10K, 5. Corrida_21K");
		Integer provaEscolhida = scan.nextInt();
		OpcaoProva provaEscolhido = whatProva(provaEscolhida);
		inscricao.setOpcao(provaEscolhido);
		
		inscricao.setSituacaoInscricao(SituacaoInscricao.EM_DIVIDA);

		inscricoes.add(inscricao);
		
		obterLinha();
		System.out.println("Inscrição efetuada com sucesso, o numero da inscrição é: " + i);
		obterLinha();
	}
	
	// Opção 2 - Editar Inscrição
	public void editar() {
		System.out.println("Informe o numero da Inscrição: ");
		Integer numero = scan.nextInt();
		InscricaoCorredor inscricaoValidada = validarInscricao(numero);
		if(inscricaoValidada != null) {
			System.out.println("Nome: ");
			String nome = scan.next();
			inscricaoValidada.setNome(nome);
			
			System.out.println("CPF: ");
			String cpf = scan.next();
			inscricaoValidada.setCpf(cpf);
			
			System.out.println("Numero da Camiseta: Ex: 1. P, 2. M, 3. G, 4. GG, 5. XG e 6. XGG.");
			Integer camiseta = scan.nextInt();
			NumeroCamiseta camisetaEscolhida = whatCamiseta(camiseta);
			inscricaoValidada.setNumeroCamiseta(camisetaEscolhida);
			
			System.out.println("Informe a prova: Ex: 1. Kids, 2. Caminhada_5K, 3. Corrida_5K, 4. Corrida_10K, 5. Corrida_21K");
			Integer provaEscolhida = scan.nextInt();
			OpcaoProva provaEscolhido = whatProva(provaEscolhida);
			inscricaoValidada.setOpcao(provaEscolhido);
			
			obterLinha();
			System.out.println("Dados editados com sucesso!!");
			obterLinha();
		}else {
			obterLinha();
			System.out.println("Numero de inscrição incorreto, por favor informe corretamente!!");
			obterLinha();
		}
	}
	
	// Validar se as inscriçoes existem
	private InscricaoCorredor validarInscricao(Integer numero) {
		for(InscricaoCorredor i : inscricoes) {
			if(i.getNumeroInscricao() == numero) {
				return i;
			}
		}
		return null;
	}
	
	public void obterLinha() {
		System.out.println("==========================================");
	}
	
	private NumeroCamiseta whatCamiseta(Integer camisetaEscolhida) {
		return camisetaEscolhida == 1 ? NumeroCamiseta.P : 
			camisetaEscolhida == 2 ? NumeroCamiseta.M :
			camisetaEscolhida == 3 ? NumeroCamiseta.G :
			camisetaEscolhida == 4 ? NumeroCamiseta.GG :
			camisetaEscolhida == 5 ? NumeroCamiseta.XG : 
			NumeroCamiseta.XGG;
	}
	
	private OpcaoProva whatProva(Integer provaEscolhida) {
		return provaEscolhida == 1 ? OpcaoProva.Kids : 
			provaEscolhida == 2 ? OpcaoProva.Caminhada_5K :
			provaEscolhida == 3 ? OpcaoProva.Corrida_5K :
			provaEscolhida == 4 ? OpcaoProva.Corrida_10K :
			OpcaoProva.Corrida_21K;
	}
}
