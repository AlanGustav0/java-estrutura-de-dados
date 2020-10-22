package view;

import javax.swing.JOptionPane;

import controller.FilaDinamica;

public class Principal {

	public static void main(String[] args) {

		FilaDinamica fila = new FilaDinamica();

		int opc = 0;
		int id, qtdSemestres;
		String nome, areaCurso, periodo, mensagem;

		while (opc != 9) {

			opc = Integer.parseInt(JOptionPane.showInputDialog("Cadastro\n 1 - Adiciona na Fila\n 2 - "
					+ "Remove da Fila\n 3 - Verifica Fila \n " + "4 - Mostra Fila \n 9 - Finaliza"));

			switch (opc) {

			case 1:

				id = Integer.parseInt(JOptionPane.showInputDialog("Insira o id do curso: "));
				nome = JOptionPane.showInputDialog("Insira o nome do aluno: ");
				areaCurso = JOptionPane.showInputDialog("Insira a área do curso: ");
				qtdSemestres = Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade de semestres: "));
				periodo = JOptionPane.showInputDialog("Insira o período do curso: ");
				mensagem = fila.adiciona(id, nome, areaCurso, qtdSemestres, periodo);

				if (mensagem == " ") {
					JOptionPane.showMessageDialog(null, "Erro, aluno não inserido na fila");
				} else {
					JOptionPane.showMessageDialog(null, "Aluno adicionado na fila: \n" + mensagem);
				}

				break;

			case 2:
				mensagem = fila.remove();

				if (mensagem == " ") {
					JOptionPane.showMessageDialog(null, "Erro, aluno não inserido na fila");
				} else {
					JOptionPane.showMessageDialog(null, "Aluno removido da fila:  \n" + mensagem);
				}
				break;

			case 3:
				if (fila.verificaFila()) {
					JOptionPane.showMessageDialog(null, "A fila está vazia");
				} else {
					JOptionPane.showMessageDialog(null, "A fila não está vazia");
				}
				break;

			case 4:

				mensagem = fila.percorreFila();
				if (mensagem == " ") {
					JOptionPane.showMessageDialog(null, "Não há alunos na fila");
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
