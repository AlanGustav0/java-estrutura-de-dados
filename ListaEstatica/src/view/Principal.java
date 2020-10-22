package view;

import javax.swing.JOptionPane;

import controller.MetodosLista;

public class Principal {

	public static void main(String[] args) {
		MetodosLista metodos = new MetodosLista();

		int opc = 0, posicao = 0;
		int id, qtdSemestres;
		String nome, areaCurso, periodo, mensagem;

		while (opc != 9) {

			opc = Integer.parseInt(JOptionPane
					.showInputDialog("Cadastro\n 1 - Adiciona Inicio\n 2 - Adiciona Final\n 3 - Adiciona posição "
							+ "específica\n 4 - Remove inicio\n 5 - Remove Final\n 6 - Remove em posição específica\n 7 - Verifica lista vazia \n 8 - "
							+ "Mostra Lista\n 9 - Finaliza"));

			switch (opc) {

			case 1:

				id = Integer.parseInt(JOptionPane.showInputDialog("Insira o id do curso: "));
				nome = JOptionPane.showInputDialog("Insira o nome do aluno: ");
				areaCurso = JOptionPane.showInputDialog("Insira a área do curso: ");
				qtdSemestres = Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade de semestres: "));
				periodo = JOptionPane.showInputDialog("Insira o período do curso: ");
				mensagem = metodos.adicionaInicio(id, nome, areaCurso, qtdSemestres, periodo);

				if (mensagem == null) {
					JOptionPane.showMessageDialog(null, "Erro, aluno não inserido na lista");
				} else {
					JOptionPane.showMessageDialog(null, "Aluno " + nome + " adicionado no início da lista \n");
				}

				break;

			case 2:
				id = Integer.parseInt(JOptionPane.showInputDialog("Insira o id do curso: "));
				nome = JOptionPane.showInputDialog("Insira o nome do aluno: ");
				areaCurso = JOptionPane.showInputDialog("Insira a área do curso: ");
				qtdSemestres = Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade de semestres: "));
				periodo = JOptionPane.showInputDialog("Insira o período do curso: ");
				mensagem = metodos.adicionaFinal(id, nome, areaCurso, qtdSemestres, periodo);

				if (mensagem == null) {
					JOptionPane.showMessageDialog(null, "Erro, aluno não inserido na lista");
				} else {
					JOptionPane.showMessageDialog(null, "Aluno " + nome + " adicionado no final da lista \n");
				}
				break;

			case 3:
				id = Integer.parseInt(JOptionPane.showInputDialog("Insira o id do curso: "));
				nome = JOptionPane.showInputDialog("Insira o nome do aluno: ");
				areaCurso = JOptionPane.showInputDialog("Insira a área do curso: ");
				qtdSemestres = Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade de semestres:"));
				periodo = JOptionPane.showInputDialog("Insira o período do curso: ");
				posicao = Integer.parseInt(JOptionPane.showInputDialog("Insira a posicao que deseja inserir: "));
				mensagem = metodos.adicionaPosicaoEspecifica(id, nome, areaCurso, qtdSemestres, periodo, posicao);

				if (mensagem == null) {
					JOptionPane.showMessageDialog(null, "Erro, aluno não inserido na lista");
				} else {
					JOptionPane.showMessageDialog(null, "Aluno " + nome + " adicionado na posição: " + posicao);
				}
				break;

			case 4:
				mensagem = metodos.removeInicio();
				if (mensagem == null) {
					JOptionPane.showMessageDialog(null, "Nenhum aluno removido");
				} else {
					JOptionPane.showMessageDialog(null, "O Aluno removido foi: \n" + mensagem);
				}

				break;

			case 5:

				mensagem = metodos.removeFinal();
				if (mensagem == null) {
					JOptionPane.showMessageDialog(null, "Nenhum aluno removido");
				} else {
					JOptionPane.showMessageDialog(null, "O Aluno removido foi: \n" + mensagem);
				}

				break;

			case 6:
				posicao = Integer.parseInt(JOptionPane.showInputDialog("Insira o valor da posição desejada: "));

				mensagem = metodos.removePosicaoEspecifica(posicao);

				if (mensagem == null) {
					JOptionPane.showMessageDialog(null, "Nenhum aluno removido");
				} else {
					JOptionPane.showMessageDialog(null, "O Aluno removido foi: " + mensagem);
				}

				break;

			case 7:
				if (metodos.listaVazia()) {
					JOptionPane.showMessageDialog(null, "Verdadeiro: A lista está vazia");
				} else {
					JOptionPane.showMessageDialog(null, "Falso: A lista não está vazia");
				}
				break;

			case 8:

				mensagem = metodos.percorre();
				if (mensagem == null) {
					JOptionPane.showMessageDialog(null, "Não há alunos na lista");
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
