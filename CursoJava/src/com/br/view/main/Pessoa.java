package com.br.view.main;

public abstract  class Pessoa { // com esse abstratc, essa classe nao pode ser instanciada por outras classes !
	
	protected String nome;
	protected int idade;
	protected String cpf;
	
	// Método abstrato que fica na classe pai é obrigatorio para as classes filhas
	public abstract double mesada();
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public boolean pessoaMaiorDeIdade() {
		return idade >= 18;  // java retorna um boolean, se idade for maior = true, senao false 
	}
	
	public String msgAlunoMaiorDeIdade() {
		return this.pessoaMaiorDeIdade() ? "Aluno maior de idade" : "aluno menor de idade";
	}
	
	
}
