 package com.br.view.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import com.br.DTO.aluno.Diretor;
import com.br.DTO.aluno.Disciplina;
import com.br.DTO.aluno.aluno;
import com.br.constantes.StatusAluno;
import com.br.interfaces.PermitirAcesso;

public class MainEscola {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
		
		String login = JOptionPane.showInputDialog("informe o login");
		String senha = JOptionPane.showInputDialog("informe a senha");
		
		//METOD more simple, without parameters, but can cause bugs in more complicated systems. if use this, take off the parameters below and in interface
//		Diretor diretor = new Diretor();
//		diretor.setLogin(login);
//		diretor.setSenha(senha);
		
		PermitirAcesso diretor = new Diretor();
		
		
		
		if(diretor.autenticar(login, senha)) { // if true get access, if false don't get in the system 
		
		 List<aluno> alunos = new ArrayList<aluno>();
		
		// Todas listas abaixo serão substituidas pelo HashMap
		// List<aluno> aprovados = new ArrayList<aluno>();
		// List<aluno> reprovados = new ArrayList<aluno>();
		
		// é uma lista que dentro temos uma chave que identifica uma sequencia de valores 
		HashMap<String, List<aluno>> maps = new HashMap <String, List<aluno>>();
		
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
					disciplina.nota[i] = Double.parseDouble(JOptionPane.showInputDialog("Qual a nota da disciplina " + i + " ?"));
					
					disciplina.setDisciplina(nomeDisciplina);
					
					
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
		
		
			// INICIALIZANDO VALORES DA LISTA COM LISTA VAZIA 
			maps.put(StatusAluno.APROVADO, new ArrayList<aluno>());
			maps.put(StatusAluno.REPROVADO, new ArrayList<aluno>());
		
			for(aluno aluno : alunos) {
				
				if(aluno.alunoAprovadoConstante().equalsIgnoreCase(StatusAluno.APROVADO)) {
					maps.get(StatusAluno.APROVADO).add(aluno); // recupera a lista de alunos do maps.put
				} else if(aluno.alunoAprovadoConstante().equalsIgnoreCase(StatusAluno.REPROVADO)) {
					maps.get(StatusAluno.REPROVADO).add(aluno);
				}
		}
			
			
			// DIVISAO SEM O HASHMAPS 
//			for(aluno aluno : alunos) {
//				
//				if(aluno.alunoAprovadoConstante().equalsIgnoreCase(StatusAluno.APROVADO)) {
//					aprovados.add(aluno);
//				} else if(aluno.alunoAprovadoConstante().equalsIgnoreCase(StatusAluno.REPROVADO)) {
//					reprovados.add(aluno);
//				}
//			}
			
			System.out.println("----- Lista dos Aprovados -------");
			for(aluno aprovado : maps.get(StatusAluno.APROVADO) ) {
				System.out.println("aluno: " + aprovado.getNome() +" "+ aprovado.alunoAprovadoConstante() + " com  " + aprovado.getMedia() + " " + aprovado.msgAlunoMaiorDeIdade());
			}
			System.out.println("----- Lista dos Reprovados -----");
			for(aluno reprovado : maps.get(StatusAluno.REPROVADO)) {
				System.out.println("aluno: " + reprovado.getNome() +" "+ reprovado.alunoAprovadoConstante() +" com  " + reprovado.getMedia() + " " + reprovado.msgAlunoMaiorDeIdade());
			}
		
		
		
//		for(aluno aluno : alunos) {
//		
//			System.out.println("a media da nota e " + aluno.getMedia());
//			System.out.println("Aluno " + aluno.getNome() + "foi " + aluno.alunoAprovadoConstante());
//// Com boolean: System.out.println("Aluno " + aluno.getNome() + "foi " + (aluno.alunoAprovadoConstante() ? "aprovado" : "reprovado"));
//			System.out.println("--------------------------------------------------------------------------");
//			
//			for(Disciplina disc : aluno.getDisciplinas()) {
//				System.out.println("Materia: " + disc.getDisciplina() + " nota: " + disc.getNota());
//			}
//			
//		}
		
			
		}else {
			JOptionPane.showMessageDialog(null, "Login Invalido!");
		}
	
	
		
	}catch (Exception e) {
		
		//StringBuilder saida = new StringBuilder();
		e.printStackTrace(); // imprime erro no console (ESSENCIAL)
		
		
		for (int pos = 0; pos < e.getStackTrace().length; pos++) { // getStackTrace is an array 
			
			System.out.println("Classe de erro: " + e.getStackTrace()[pos].getClass());
			System.out.println("Método do erro: " + e.getStackTrace()[pos].getMethodName());
			System.out.println("Linha do erro: " + e.getStackTrace()[pos].getLineNumber());
			System.out.println("Tipo do erro: " + e.getStackTrace()[pos].getClass().getName());
			
		}
		
		JOptionPane.showMessageDialog(null, "Erro ao processar notas");
	}finally {  // BLOCO FINALY IS ALLWAYS EXCECUTED 
		JOptionPane.showMessageDialog(null, "Voltem sempre!");
	}

}
	
}

////----------  Substituição de objeto dentro de uma lista   -----------
//for (int pos = 0; pos < alunos.size(); pos++) {
//
//aluno aluno = new aluno();
//

//if(aluno.getNome().equalsIgnoreCase("joao")) {
//	aluno trocar = new aluno(); // precisa de um novo aluno !
//	trocar.setNome("alberto");
//	
//	
//	//como é um novo aluno tem que setar as novas notas e disciplinas 
//	Disciplina disciplina = new Disciplina(); 
//	disciplina.setDisciplina("matematica");
//	disciplina.setNota(9);
//	disciplina.setDisciplina("historia");
//	disciplina.setNota(9);
//	disciplina.setDisciplina("geografia");
//	disciplina.setNota(9);
//	disciplina.setDisciplina("ingles");
//	disciplina.setNota(9);
//	
//	trocar.getDisciplinas().add(disciplina);
//	
//	alunos.set(pos, trocar);  // o indice, o objeto - trocando na lista 
//	aluno = alunos.get(pos); // trocando no objeto - fazer isso pra lá em baixo ele não ficar com o objeto antigo
//	
//}
// --------- fim da substituição de objeto ----------- 
