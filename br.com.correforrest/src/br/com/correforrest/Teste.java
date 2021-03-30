package br.com.correforrest;

import java.text.NumberFormat;
import java.util.Locale;

public class Teste {
	//08 05 2015

	public static void main(String[] args) {
		NumberFormat eua = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat india = NumberFormat.getCurrencyInstance(new Locale("en", "in"));
		NumberFormat china = NumberFormat.getCurrencyInstance(Locale.CHINA);
		NumberFormat franca = NumberFormat.getCurrencyInstance(Locale.FRANCE);
		
		double payment = 1.00;
		String a = Double.toString(payment);
		
		System.out.println("US: " + eua.format(payment));
		System.out.println("US: " + india.format(payment));
		System.out.println("US: " + china.format(payment));
		System.out.println("US: " + franca.format(payment));
	}
	
}



