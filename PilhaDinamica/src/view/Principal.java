package view;

import javax.swing.JOptionPane;

import controller.PilhaDinamica;

public class Principal {

	public static void main(String[] args) {
		PilhaDinamica pilha = new PilhaDinamica();

		int opc = 0;
		int id, qtdSemestres;
		String nome, areaCurso, periodo, mensagem;

		while (opc != 9) {

			opc = Integer.parseInt(JOptionPane.showInputDialog("Cadastro\n 1 - Adiciona na Pilha\n 2 - "
					+ "Remove da Pilha\n 3 - Verifica Pilha \n " + "4 - Mostra Pilha \n 9 - Finaliza"));

			switch (opc) {

			case 1:

				id = Integer.parseInt(JOptionPane.showInputDialog("Insira o id do curso: "));
				nome = JOptionPane.showInputDialog("Insira o nome do aluno: ");
				areaCurso = JOptionPane.showInputDialog("Insira a área do curso: ");
				qtdSemestres = Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade de semestres: "));
				periodo = JOptionPane.showInputDialog("Insira o período do curso: ");
				mensagem = pilha.adiciona(id, nome, areaCurso, qtdSemestres, periodo);

				if (mensagem ==  " ") {
					JOptionPane.showMessageDialog(null, "Erro, aluno não inserido na pilha");
				} else {
					JOptionPane.showMessageDialog(null, "Aluno adicionado: \n" + mensagem);
				}

				break;

			case 2:
				mensagem = pilha.remove();

				if (mensagem ==  " ") {
					JOptionPane.showMessageDialog(null, "Erro, aluno não inserido na pilha");
				} else {
					JOptionPane.showMessageDialog(null, "Aluno removido da pilha:  \n" + mensagem);
				}
				break;

			case 3:
				if (pilha.verificaPilha()) {
					JOptionPane.showMessageDialog(null, "A pilha está vazia");
				} else {
					JOptionPane.showMessageDialog(null, "A pilha não está vazia");
				}
				break;

			case 4:

				mensagem = pilha.percorrePilha();
				if (mensagem == " ") {
					JOptionPane.showMessageDialog(null, "Não há alunos na pilha");
				} else {
					JOptionPane.showMessageDialog(null, mensagem);
				}

				break;

			case 9:
				JOptionPane.showMessageDialog(null, "Programa Finalizado");
				break;

			default:

				JOptionPane.showMessageDialog(null, "Opção inválida!");
				break;

			}
		}

	}

}
