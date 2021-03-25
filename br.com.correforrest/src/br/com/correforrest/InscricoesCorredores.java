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
	
	public void adicionar(InscricaoCorredor inscricao) {	
		
		Integer i = 0;
		System.out.println("Informe seu nome: ");
		String nome = scan.next();
		inscricao.setNome(nome);
		
		System.out.println("Informe seu CPF: ");
		String cpf = scan.next();
		inscricao.setCpf(cpf);

		inscricao.setNumeroInscricao(i++);
		System.out.println("Informe as letras da Camiseta: Ex: 1. P, 2. M, 3. G, 4. GG, 5. XG e 6. XGG.");
		Integer camisetaEscolhida = scan.nextInt();
		NumeroCamiseta cursoEscolhido = whatCurso(camisetaEscolhida);
		inscricao.setNumeroCamiseta(cursoEscolhido);
		
		System.out.println("Informe a prova: Ex: 1. Kids, 2. Caminhada_5K, 3. Corrida_5K, 4. Corrida_10K, 5. Corrida_21K");
		Integer provaEscolhida = scan.nextInt();
		OpcaoProva provaEscolhido = whatProva(provaEscolhida);
		inscricao.setOpcao(provaEscolhido);
		
		inscricao.setSituacaoInscricao(SituacaoInscricao.EM_DIVIDA);

		inscricoes.add(inscricao);
		
		obterLinha();
		System.out.println("Inscrição efetuada com sucesso!!");
		obterLinha();
	}
	
	private NumeroCamiseta whatCurso(Integer camisetaEscolhida) {
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
	
	public void obterLinha() {
		System.out.println("==========================================");
	}
}
