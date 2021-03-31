package br.com.correforrest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import enums.NumeroCamiseta;
import enums.OpcaoProva;
import enums.SituacaoInscricao;

public class InscricoesCorredores {
	
	Scanner scan = new Scanner(System.in);
		
	List<InscricaoCorredor> inscricoes = new ArrayList<>();
	List<InscricaoCorredor> kids = new ArrayList<>();
	List<InscricaoCorredor> caminhada = new ArrayList<>();
	List<InscricaoCorredor> corrida5k = new ArrayList<>();
	List<InscricaoCorredor> corrida10k = new ArrayList<>();
	List<InscricaoCorredor> corrida21k = new ArrayList<>();
	
	// Opção 1 - Realizar Inscrição
	public void adicionar(InscricaoCorredor inscricao) {	
		
		Integer i = 0;
		System.out.println("Informe seu nome: ");
		String nome = scan.next();
		inscricao.setNome(nome);
		
		System.out.println("Informe seu CPF: ");
		String cpf = scan.next();
		inscricao.setCpf(cpf);
		i++;
		inscricao.setNumeroInscricao(i);
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
	
	// Gravar dados dos Corredores
	public void gravar() {
		try {
			File arquivoKids = new File("kids.txt");
			File arquivoCaminhada = new File("caminhada5k.txt");
			File arquivoC5k = new File("corrida5k.txt");
			File arquivoC10k = new File("corrida10k.txt");
			File arquivoC21k = new File("corrida21k.txt");
			
			if(inscricoes.isEmpty()) {
				obterLinha();
				System.out.println("Dados inexistentes para gravar!!");
				obterLinha();
				return;
			}
			
			if(!arquivoKids.exists() || !arquivoCaminhada.exists() || !arquivoC5k.exists() || !arquivoC10k.exists() || !arquivoC21k.exists()) {
				arquivoKids.createNewFile();
				arquivoCaminhada.createNewFile();
				arquivoC5k.createNewFile();
				arquivoC10k.createNewFile();
				arquivoC21k.createNewFile();
			}

			for(InscricaoCorredor iC : inscricoes) {
				if(iC.getOpcao().equals(OpcaoProva.Kids)) {
					kids.add(iC);
				}else if(iC.getOpcao().equals(OpcaoProva.Caminhada_5K)) {
					caminhada.add(iC);
				}else if(iC.getOpcao().equals(OpcaoProva.Corrida_5K)) {
					corrida5k.add(iC);
				}else if(iC.getOpcao().equals(OpcaoProva.Corrida_10K)) {
					corrida10k.add(iC);
				}else {
					corrida21k.add(iC);
				}
			}
				
				if(!kids.isEmpty()) {
					var bf = getArquivo(arquivoKids);
					for(InscricaoCorredor i : kids) {
						bf.write("==========================================");
						bf.newLine();
						bf.write("Nome: " + i.getNome());
						bf.newLine();
						bf.write("CPF: " + i.getCpf());
						bf.newLine();
						bf.write("Numero da Inscrição: " + i.getNumeroInscricao());
						bf.newLine();
						bf.write("Numero da Camisa: " + i.getNumeroCamiseta());
						bf.newLine();
						bf.write("Prova: " + i.getOpcao());
						bf.newLine();
					}
					bf.close();
					getMessage("kids.txt");
				}
				
				if(!caminhada.isEmpty()) {
					var bf = getArquivo(arquivoCaminhada);
					for(InscricaoCorredor i : caminhada) {
						bf.write("==========================================");
						bf.newLine();
						bf.write("Nome: " + i.getNome());
						bf.newLine();
						bf.write("CPF: " + i.getCpf());
						bf.newLine();
						bf.write("Numero da Inscrição: " + i.getNumeroInscricao());
						bf.newLine();
						bf.write("Numero da Camisa: " + i.getNumeroCamiseta());
						bf.newLine();
						bf.write("Prova: " + i.getOpcao());
						bf.newLine();
					}
					bf.close();
					getMessage("caminhada5k.txt");
				}
				
				if(!corrida5k.isEmpty()) {
					var bf = getArquivo(arquivoC5k);
					for(InscricaoCorredor i : corrida5k) {
						bf.write("==========================================");
						bf.newLine();
						bf.write("Nome: " + i.getNome());
						bf.newLine();
						bf.write("CPF: " + i.getCpf());
						bf.newLine();
						bf.write("Numero da Inscrição: " + i.getNumeroInscricao());
						bf.newLine();
						bf.write("Numero da Camisa: " + i.getNumeroCamiseta());
						bf.newLine();
						bf.write("Prova: " + i.getOpcao());
						bf.newLine();
					}
					bf.close();
					getMessage("corrida5k.txt");
				}

				if(!corrida10k.isEmpty()) {
					var bf = getArquivo(arquivoC10k);
					for(InscricaoCorredor i : corrida10k) {
						bf.write("==========================================");
						bf.newLine();
						bf.write("Nome: " + i.getNome());
						bf.newLine();
						bf.write("CPF: " + i.getCpf());
						bf.newLine();
						bf.write("Numero da Inscrição: " + i.getNumeroInscricao());
						bf.newLine();
						bf.write("Numero da Camisa: " + i.getNumeroCamiseta());
						bf.newLine();
						bf.write("Prova: " + i.getOpcao());
						bf.newLine();
					}
					bf.close();
					getMessage("corrida10k.txt");
				}

				if(!corrida21k.isEmpty()){
					var bf = getArquivo(arquivoC21k);
					for(InscricaoCorredor i : corrida21k) {
						bf.write("==========================================");
						bf.newLine();
						bf.write("Nome: " + i.getNome());
						bf.newLine();
						bf.write("CPF: " + i.getCpf());
						bf.newLine();
						bf.write("Numero da Inscrição: " + i.getNumeroInscricao());
						bf.newLine();
						bf.write("Numero da Camisa: " + i.getNumeroCamiseta());
						bf.newLine();
						bf.write("Prova: " + i.getOpcao());
						bf.newLine();
					}
					bf.close();
					getMessage("corrida21k.txt");
				}
				
		}catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	private BufferedWriter getArquivo(File arquivoKids) throws IOException {
		FileWriter fw = new FileWriter(arquivoKids.getAbsoluteFile());
		BufferedWriter bf = new BufferedWriter(fw);
		return bf;
	}
	
	private void getMessage(String str) {
		System.out.println("============================================================");
		System.out.printf("Arquivo %s criado/gravado com sucesso!!", str);
		System.out.println();
		System.out.println("============================================================");
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
