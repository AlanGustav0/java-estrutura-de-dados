package Ex03_Atividade_EstruturaDeDados;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {

		ListaAlunos lista = new ListaAlunos();

		int opcao = 0;
		int ra;
		String nome, turma, semestre;
		String aluno = "";

		while (opcao != 9) {

			opcao = Integer.parseInt(JOptionPane.showInputDialog("***Lista de Alunos***\n"
					+ "1-Adicionar no início\n 2-Adicionar no Final\n 3-Remover no início\n 4-Remover no Final\n "
					+ "5-Remover do meio da lista\n 6-Adicionar no meio da lista\n 7-Verificar se lista está vazia\n 8-Mostrar lista atual\n 9-Finalizar"));

			switch (opcao) {
			case 1:
				ra = Integer.parseInt(JOptionPane.showInputDialog("Insira o RA do aluno:"));
				nome = JOptionPane.showInputDialog("Insira o nome do aluno: ");
				turma = JOptionPane.showInputDialog("Insira a turma do aluno: ");
				semestre = JOptionPane.showInputDialog("Insira o semestre: ");
				lista.adicionaInicio(ra, nome, turma, semestre);
				break;

			case 2:
				ra = Integer.parseInt(JOptionPane.showInputDialog("Insira o RA do aluno:"));
				nome = JOptionPane.showInputDialog("Insira o nome do aluno: ");
				turma = JOptionPane.showInputDialog("Insira a turma do aluno: ");
				semestre = JOptionPane.showInputDialog("Insira o semestre: ");
				lista.adicionaFinal(ra, nome, turma, semestre);

				JOptionPane.showMessageDialog(null, "O aluno " + nome + " foi adicionado no final da lista");
				break;

			case 3:
				aluno = lista.removeInicio();

				if (aluno == null) {
					JOptionPane.showMessageDialog(null,
							"Nenhum aluno foi removido, verifique a opção 7 do menu de opções.");
				} else {
					JOptionPane.showMessageDialog(null, "O aluno " + aluno + " foi removido do início lista.");
				}
				break;

			case 4:
				aluno = lista.removeFinal();
				if (aluno == null) {
					JOptionPane.showMessageDialog(null,
							"Nenhum aluno foi removido, verifique a opção 7 do menu de opções.");
				} else {
					JOptionPane.showMessageDialog(null, "O aluno " + aluno + " foi removido do final da lista.");
				}
				break;

			case 5:
				aluno = lista.removeMeio();
				if (aluno == null) {
					JOptionPane.showMessageDialog(null,
							"Nenhum aluno foi removido, verifique a opção 7 do menu de opções.");
				} else if (aluno == " ") {
					JOptionPane.showMessageDialog(null, "Posição inválida!");
				} else {
					JOptionPane.showMessageDialog(null, "O aluno " + aluno + " foi removido da lista");
				}

				break;

			case 7:
				if (lista.listaVazia()) {
					JOptionPane.showMessageDialog(null, "A lista está vazia!");
				} else {
					JOptionPane.showMessageDialog(null, "A lista não está vazia.");
				}
				break;

			case 8:
				JOptionPane.showMessageDialog(null, "***Relação de alunos na lista***: \n" + lista);
				break;

			default:
				break;
			}
		}

	}

}
