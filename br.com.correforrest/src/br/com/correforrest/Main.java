package br.com.correforrest;

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
			System.out.println("0.  Sair.");
			opcao = scan.nextInt();
			
			if(opcao == 1) {
				InscricaoCorredor inscricao = new InscricaoCorredor();
				inscricoes.adicionar(inscricao);
			}
			
		}while(opcao != 0); {
			
		}

	}

}
