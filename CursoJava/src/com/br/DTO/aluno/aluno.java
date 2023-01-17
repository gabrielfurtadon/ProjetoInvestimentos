package com.br.DTO.aluno;

import java.util.ArrayList;
import java.util.List;

import com.br.DTO.aluno.Disciplina;

public class aluno {

	private String nome;
	private int idade;
	
	private List<Disciplina>  disciplinas = new ArrayList<Disciplina>(); // sempre que for variavel lista coloca o nome no plural 
	
	
	
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
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
	
	public double getMedia() {
		double somaNotas = 0;
		for(Disciplina disciplina : disciplinas) {
			somaNotas += disciplina.getNota();	
		}
		return somaNotas / disciplinas.size();
	}
	
	public boolean alunoAprovado() {
		double media = this.getMedia();
		if(media >= 6) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
}
