package model;

import javax.swing.JOptionPane;

import interfaces.Autentication;

public class AgenteAutonomo implements Autentication{
	
	String login;
	String senha;

	
	
	public boolean autenticar(String login, String senha) {
			if(login.equalsIgnoreCase("admin") && senha.equalsIgnoreCase("admin")) {
				return true;
			}else {
				return false; 
			}
			
	}

	
	
}
