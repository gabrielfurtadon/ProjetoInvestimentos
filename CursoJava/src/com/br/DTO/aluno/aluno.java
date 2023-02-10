package com.br.DTO.aluno;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.br.DTO.aluno.Disciplina;
import com.br.constantes.StatusAluno;
import com.br.view.main.Pessoa;

public class aluno extends Pessoa{

	
	private List<Disciplina>  disciplinas = new ArrayList<Disciplina>(); // sempre que for variavel lista coloca o nome no plural 
	
	
	
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	
	
	public double getMedia() {
		double somaNotas = 0;
		for(Disciplina disciplina : disciplinas) {
			somaNotas += disciplina.mediaNotas();	
		}
		return somaNotas / disciplinas.size();
	}
	
	
	// METODO DE APROVAR DO BOOLEAN  ( MAIS UTILIZADO NO DIA A DIA) 
//	public boolean alunoAprovado() {
//		double media = this.getMedia();
//		if(media >= 6) {
//			return true;
//		} else {
//			return false;
//		}
//	}
	
	
	// METODO DE APROVAR COM CONSTANTE - PARA TRINAR CONSTANTES
	public String alunoAprovadoConstante() {
		double media = this.getMedia();
		if(media >= 6) {
			return StatusAluno.APROVADO;
		} else {
			return StatusAluno.REPROVADO;
		}
		}
	
	// identifica método sobrescrito -- SÓ QUE AI PODE MUDAR O METODO 
	@Override 
	public boolean pessoaMaiorDeIdade() {
		//return >= 21; PODERIA MUDAR O METODO NESSA CLASSE POR EXEMPLO
		return super.pessoaMaiorDeIdade();
	}
	
	
	//Método que é Obrigatorio para ser feito, pois é abstrario na classe mae
	@Override
	public double mesada() {
		
		return 50;
	}
	
	
	
}
