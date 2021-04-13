package br.com.correforrest;

import java.io.File;
import java.util.Scanner;

public class Main {
	
	static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		InscricoesCorredores inscricoes = new InscricoesCorredores();
		Integer opcao;
		
		
		do {
			System.out.println("============================================");
			System.out.println("PROJETO - CORRE FORREST CORRE");
			System.out.println("============================================");
			System.out.println("1. Realizar Inscrição.");
			System.out.println("2. Editar Inscrição.");
			System.out.println("3. Gravar os dados dos corredores.");
			System.out.println("4. Ler os dados dos corredores.");
			System.out.println("5. Pagar inscrição.");
			System.out.println("0.  Sair.");
			opcao = scan.nextInt();
			
			if(opcao == 1) {
				InscricaoCorredor inscricao = new InscricaoCorredor();
				inscricoes.adicionar(inscricao);
			}
			
			if(opcao == 2) {
				inscricoes.editar();
			}
			
			if(opcao == 3) {
				inscricoes.gravar();
			}
			
			if(opcao == 4) {
				inscricoes.ler();
			}
			
			if(opcao == 5) {
				inscricoes.makePayment();
			}
			
		}while(opcao != 0); {
			File arquivoKids = new File("kids.txt");
			File arquivoCaminhada = new File("caminhada5k.txt");
			File arquivoC5k = new File("corrida5k.txt");
			File arquivoC10k = new File("corrida10k.txt");
			File arquivoC21k = new File("corrida21k.txt");
			
			// Apagando
			arquivoKids.delete();
			arquivoCaminhada.delete();
			arquivoC5k.delete();
			arquivoC10k.delete();
			arquivoC21k.delete();
		}

	}

}
