package com.br.view.main;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.br.DTO.aluno.Disciplina;
import com.br.DTO.aluno.aluno;

public class MainEscola {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<aluno> alunos = new ArrayList<aluno>();
		
		int op = 0;
		
		for (int qtd = 0; qtd <= 1; qtd++) { 
			
			while(op == 0) {
				
				
				aluno aluno1 = new aluno();
				
				String nome = JOptionPane.showInputDialog("Qual o nome do aluno?");
				String idade = JOptionPane.showInputDialog("Qual a idade do aluno?");
				
			
				aluno1.setNome(nome);
				aluno1.setIdade(Integer.valueOf(idade));
				
				for(int i = 0; i <= 3; i++) {
					Disciplina disciplina = new Disciplina();
					String nomeDisciplina = JOptionPane.showInputDialog("Qual o nome da disciplina " + i + " ?");
					String notaDisciplina = JOptionPane.showInputDialog("Qual a nota da disciplina " + i + " ?");
					
					disciplina.setDisciplina(nomeDisciplina);
					disciplina.setNota(Double.parseDouble(notaDisciplina));
					
					aluno1.getDisciplinas().add(disciplina);	
				}
				
				aluno1.getMedia();
				
				
				
				
				
					// Remover Disciplina - nesse input, yes = 0 | no = 1
					int escolha = JOptionPane.showConfirmDialog(null, "Deseja excluir alguma matéria?");
					
					if(escolha == 0) {
						// ---------- Laço de Repetição While ------------------ // 
						int continuarRemover = 0;
						int posicaoRemovida = 0; // esse posRemovida vai garantir que a posicao seja a certa, pq por exemplo, se eu 
						// removo a materia 2, agora a lista esta 0 1 2, mas eu quero remover a materia 3 logo em seguiida, para nao 
						// dar erro ele faz 3 - pos (que agora é 1), portanto 2, e removera a materia certa!
						 
						while (continuarRemover == 0) {
						String remover = JOptionPane.showInputDialog("Qual Disciplina deseja remover ? 0, 1, 2 ou 3");
						aluno1.getDisciplinas().remove(Integer.valueOf(remover).intValue() - posicaoRemovida);
						posicaoRemovida++;
						continuarRemover = JOptionPane.showConfirmDialog(null, "Continuar a remover?");
						
						
						}
					}
					
					alunos.add(aluno1);
					op = JOptionPane.showConfirmDialog(null, "Deseja adiconar mais algum aluno? ");
				}
			}
		
		for (aluno aluno : alunos) {
			System.out.println("a media da nota e " + aluno.getMedia());
			System.out.println("Aluno " + aluno.getNome() + "foi " + (aluno.alunoAprovado() ? "aprovado" : "reprovado"));
			System.out.println("--------------------------------------------------------------------------");
		}
		
		
	}
	

}
