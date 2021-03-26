package br.com.correforrest;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Teste {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		try {
			int a = scan.nextInt();
			System.out.println("asd");
			int b = scan.nextInt();

			System.out.println(a/b);
			
		}catch(InputMismatchException e) {
			System.out.println("java.util.InputMismatchException:");
		}catch(Exception e) {
			System.out.println(e.fillInStackTrace());
		}

	}

}
