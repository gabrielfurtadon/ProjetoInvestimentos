package com.br.view.main;

import javax.swing.JOptionPane;

// ESTUDOS SOBRE ARRAYS 
public class ArrayVetor {

	public static void main(String[] args) {
		
		String posicoes = JOptionPane.showInputDialog("Quantas posições o Array possuirá?");
		
		/*COOMO CRIAR UM ARRAY*/ 
		// SEMPRE DEVE TER A QUANTIDADE DE POSIÇÕES DEFINIDAS
		double notas[] = new double[Integer.parseInt(posicoes)];
		//double[] notas2 = new double[4];
		
		for(int pos = 0; pos<notas.length; pos++ ) {
			notas[pos] = Double.parseDouble(JOptionPane.showInputDialog("Qual a nota " + pos)); // OU DOUBLE.VALUEOF(VALOR)
		}
		
		
		for(int i = 0; i<notas.length; i++) {
		System.out.println(notas[i]);
		}
	}
	
}
