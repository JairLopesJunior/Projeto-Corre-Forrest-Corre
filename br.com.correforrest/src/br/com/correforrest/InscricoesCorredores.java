package br.com.correforrest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
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
	Integer i = 0;
	
	// Opção 1 - Realizar Inscrição
	public void adicionar(InscricaoCorredor inscricao) {	
		
		System.out.println("Informe seu nome: ");
		String nome = scan.next();
		inscricao.setNome(nome);
		
		System.out.println("Informe seu CPF: ");
		String cpf = scan.next();
		inscricao.setCpf(cpf);
		++i;
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
					BufferedWriter bf = getArquivo(arquivoKids);
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
					BufferedWriter bf = getArquivo(arquivoCaminhada);
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
					BufferedWriter bf = getArquivo(arquivoC5k);
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
					BufferedWriter bf = getArquivo(arquivoC10k);
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
					BufferedWriter bf = getArquivo(arquivoC21k);
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
	
	public void ler(){
		try {
			File arquivoKids = new File("kids.txt");
			File arquivoCaminhada = new File("caminhada5k.txt");
			File arquivoC5k = new File("corrida5k.txt");
			File arquivoC10k = new File("corrida10k.txt");
			File arquivoC21k = new File("corrida21k.txt");
			
			if(!arquivoKids.exists() || !arquivoCaminhada.exists() || !arquivoC5k.exists() || !arquivoC10k.exists() || !arquivoC21k.exists()) {
				arquivoKids.createNewFile();
				arquivoCaminhada.createNewFile();
				arquivoC5k.createNewFile();
				arquivoC10k.createNewFile();
				arquivoC21k.createNewFile();
			}
			
			FileReader percorrerArquivo1 = new FileReader(arquivoKids);
			FileReader percorrerArquivo2 = new FileReader(arquivoCaminhada);
			FileReader percorrerArquivo3 = new FileReader(arquivoC5k);
			FileReader percorrerArquivo4 = new FileReader(arquivoC10k);
			FileReader percorrerArquivo5 = new FileReader(arquivoC21k);
			BufferedReader lerArquivo1 = new BufferedReader(percorrerArquivo1);
			BufferedReader lerArquivo2 = new BufferedReader(percorrerArquivo2);
			BufferedReader lerArquivo3 = new BufferedReader(percorrerArquivo3);
			BufferedReader lerArquivo4 = new BufferedReader(percorrerArquivo4);
			BufferedReader lerArquivo5 = new BufferedReader(percorrerArquivo5);
			
			System.out.println("==========================================");
			System.out.println("LISTA DE CORREDORES ENCONTRADOS");
			
			while(lerArquivo1.ready()) {
				String linha = lerArquivo1.readLine();
				System.out.println(linha);
			 }  
			
			while(lerArquivo2.ready()) {
				String linha = lerArquivo2.readLine();
				System.out.println(linha);
			 }  
			
			while(lerArquivo3.ready()) {
				String linha = lerArquivo3.readLine();
				System.out.println(linha);
			 }  
			
			while(lerArquivo4.ready()) {
				String linha = lerArquivo4.readLine();
				System.out.println(linha);
			 }  
			
			while(lerArquivo5.ready()) {
				String linha = lerArquivo5.readLine();
				System.out.println(linha);
			 }  
			
			 lerArquivo1.close();
			 lerArquivo2.close();
			 lerArquivo3.close();
			 lerArquivo4.close();
			 lerArquivo5.close();
			 
		}catch(Exception e) {
			System.out.println(e.fillInStackTrace());
		}
	}
	
	// 5. Pagar Inscrição
	public void makePayment() {
		System.out.println("Informe o numero da Inscrição:");
		Integer numero = scan.nextInt();
		InscricaoCorredor inscricaoValidada = validarInscricao(numero);
		if(inscricaoValidada != null) {
			inscricaoValidada.setSituacaoInscricao(SituacaoInscricao.EFETIVADA);
			obterLinha();
			System.out.println("Pagamento realizado com sucesso!!");
			obterLinha();
		}else {
			obterLinha();
			System.out.println("Numero de inscrição Inválido, por favor informe novamente!!");
			obterLinha();
		}
	}
	
	// 6. Listar Candidatos Pagantes
	public void listPayers() {
		obterLinha();
		System.out.println("Lista de Candidatos com a inscrição efetivada.");
		obterLinha();
		
		if(inscricoes.isEmpty() && kids.isEmpty() && caminhada.isEmpty() && corrida5k.isEmpty() && corrida10k.isEmpty() && corrida21k.isEmpty()) {
			System.out.println("Nenhum Candidato encontrado efetivado!!");
			return;
		}
		
		inscricoes.forEach(f -> {
			if(f.getSituacaoInscricao().equals(SituacaoInscricao.EFETIVADA)){
				System.out.println("Nome: " + f.getNome());
				System.out.println("Numero da Inscrição: " + f.getNumeroInscricao());
				obterLinha();
			}
		});
		
		kids.forEach(f -> {
			if(f.getSituacaoInscricao().equals(SituacaoInscricao.EFETIVADA)){
				System.out.println("Nome: " + f.getNome());
				System.out.println("Numero da Inscrição: " + f.getNumeroInscricao());
				obterLinha();
			}
		});
		
		caminhada.forEach(f -> {
			if(f.getSituacaoInscricao().equals(SituacaoInscricao.EFETIVADA)){
				System.out.println("Nome: " + f.getNome());
				System.out.println("Numero da Inscrição: " + f.getNumeroInscricao());
				obterLinha();
			}
		});
		
		corrida5k.forEach(f -> {
			if(f.getSituacaoInscricao().equals(SituacaoInscricao.EFETIVADA)){
				System.out.println("Nome: " + f.getNome());
				System.out.println("Numero da Inscrição: " + f.getNumeroInscricao());
				obterLinha();
			}
		});
		
		corrida10k.forEach(f -> {
			if(f.getSituacaoInscricao().equals(SituacaoInscricao.EFETIVADA)){
				System.out.println("Nome: " + f.getNome());
				System.out.println("Numero da Inscrição: " + f.getNumeroInscricao());
				obterLinha();
			}
		});
		
		corrida21k.forEach(f -> {
			if(f.getSituacaoInscricao().equals(SituacaoInscricao.EFETIVADA)){
				System.out.println("Nome: " + f.getNome());
				System.out.println("Numero da Inscrição: " + f.getNumeroInscricao());
				obterLinha();
			}
		});
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
