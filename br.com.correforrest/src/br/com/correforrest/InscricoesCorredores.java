package br.com.correforrest;

import java.util.ArrayList;
import java.util.List;

public class InscricoesCorredores {
		
	List<InscricaoCorredor> inscricoes = new ArrayList<>();
	
	public void adicionar(InscricaoCorredor inscricao) {	
		obterLinha();
		

		inscricoes.add(inscricao);
	}
	
	public void obterLinha() {
		System.out.println("==========================================");
	}
}
