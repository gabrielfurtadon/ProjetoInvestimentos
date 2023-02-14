package model;

import java.util.Scanner;

public class Investidor extends Usuario{
	
	private double patrimonio;
	Scanner sc = new Scanner(System.in);

	public double getPatrimonio() {
		return patrimonio;
	}

	public void setPatrimonio(double patrimonio) {
		this.patrimonio = patrimonio;
	}
	
	public void aportar() {
		System.out.println("Quanto deseja aportar?");
		double aporte = Double.valueOf(sc.next());
		patrimonio += aporte;
	}
	
	
	public void mostrarPatrimonio() {
		System.out.println("-----------------------------------------------");
		System.out.println("");
		System.out.println("Voce tem R$" + patrimonio + " reais investidos");
		System.out.println("");
		System.out.println("-----------------------------------------------");
	}
	
	public void simulacao() {
		double rendimento;
		System.out.println("qual será o rendimento mensal do investimento?");
		String x =  sc.next();
		double rend = Double.parseDouble(x);
		System.out.println("O valor sera investido por quantos meses?");
		String y = sc.next();
		double tempo = Double.parseDouble(y);
		rendimento = patrimonio * Math.pow((1 + rend/100), tempo);
		System.out.println("-----------------------------------------------");
		System.out.println("");
		System.out.println("O redndimento no final sera de R$" + rendimento + " reais");
		System.out.println("");
		System.out.println("-----------------------------------------------");
		
	}
	
	
	
}
