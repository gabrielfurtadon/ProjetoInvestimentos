package view;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import model.AgenteAutonomo;
import model.Investidor;


public class MainView {

	public static void main(String[] args) {
		
		List<Investidor> investidores = new ArrayList<>();
		List<AgenteAutonomo> agentes = new ArrayList<>();
		
		Investidor investidor = new Investidor();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Bem vindo a casa de investimentos!");
		System.out.println("Login: ");
		String login = sc.next();
		System.out.println("Senha: ");
		String senha = sc.next();
		
		if(login.equalsIgnoreCase("admin") && senha.equalsIgnoreCase("admin")) {
			
			
			System.out.println("Bem vindo Agente autonomo!");  
			System.out.println("O que deseja fazer?");
			System.out.println("------------------------------------"); 
			System.out.println("1 - Cadastrar novo cliente: "); 
			System.out.println("2 - Gerenciar cliente: "); 
			String op = sc.next();
			switch(op) {
			case "1":
				System.out.println("nome: ");
				investidor.setNome(sc.next());
				System.out.println("Idade: ");
				int idade = Integer.valueOf(sc.next());
				investidor.setIdade(idade);
				System.out.println("Cidade: ");
				investidor.setCidade(sc.next());
				System.out.println("Estado: ");
				investidor.setEstado(sc.next());
				System.out.println("País: ");
				investidor.setCountry(sc.next());
				System.out.println("Rg: ");
				investidor.setRg(sc.next());
				System.out.println("Cpf: ");
				investidor.setCpf(sc.next());
				investidores.add(investidor);
				break;
			case "2": 
				System.out.println("Qual o nome do investidor?");
				String name = sc.next();
				// List<Investidor> busca = investidores.stream().filter(x -> x.charAt(0) = x)
				break;
						
			}
			
			
			
			
			
		}else if(login.equalsIgnoreCase("123") && senha.equalsIgnoreCase("123")) {
			String op;
			int x;
			
			System.out.println("Bem vindo Agente cliente");  
			do {
			System.out.println("O que deseja fazer?");
			System.out.println("-----------------------------------------------"); 
			System.out.println("1 - Fazer aporte "); 
			System.out.println("2 - Ver investimentos ");
			System.out.println("3 - Simular Investimentos ");
			System.out.println("0 - Sair "); 
			op = sc.next();
			switch(op) {
			case "1": 
				investidor.aportar();
				break;
			case "2": 
				investidor.mostrarPatrimonio();
				break;
			case "3": 
				investidor.simulacao();
				break;
			}
		x = Integer.parseInt(op);
		}while(x != 0); 
	}

	
}
	
}
