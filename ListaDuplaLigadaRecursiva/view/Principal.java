package ListaDuplaLigadaRecursiva;

import javax.swing.JOptionPane;

import ListaLigada.ListaLigada;

public class Principal {

	public static void main(String[] args) {
		ListaDuplaLigadaRec lista = new ListaDuplaLigadaRec();

		int opcao = 0;
		int posicao = 0;
		int id, qtdSemestres;
		String nome, areaCurso, periodo, mensagem;

		while (opcao != 9) {

			opcao = Integer.parseInt(JOptionPane.showInputDialog("***Cadastro de Alunos \n ---------------------\n "
					+ "1-Adicionar no início\n 2-Adicionar no Final\n 3-Remover no início\n 4-Remover no Final\n "
					+ "5-Verificar se lista está vazia\n 6-Mostrar lista\n 9-Finalizar"));
			switch (opcao) {
			case 1:
				id = Integer.parseInt(JOptionPane.showInputDialog("Insira o id do curso: "));
				nome = JOptionPane.showInputDialog("Insira o nome do aluno: ");
				areaCurso = JOptionPane.showInputDialog("Insira a área do curso: ");
				qtdSemestres = Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade de semestres: "));
				periodo = JOptionPane.showInputDialog("Insira o período do curso: ");

				mensagem = lista.adicionaInicio(id, nome, areaCurso, qtdSemestres, periodo);

				if (mensagem == " ") {
					JOptionPane.showMessageDialog(null, "Erro, aluno não inserido na lista");
				} else {
					JOptionPane.showMessageDialog(null, "Aluno adicionado no início da lista: \n" + mensagem);
				}
				break;

			case 2:
				id = Integer.parseInt(JOptionPane.showInputDialog("Insira o id do curso: "));
				nome = JOptionPane.showInputDialog("Insira o nome do aluno: ");
				areaCurso = JOptionPane.showInputDialog("Insira a área do curso: ");
				qtdSemestres = Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade de semestres: "));
				periodo = JOptionPane.showInputDialog("Insira o período do curso: ");

				mensagem = lista.adicionaFinal(id, nome, areaCurso, qtdSemestres, periodo);

				if (mensagem == " ") {
					JOptionPane.showMessageDialog(null, "Erro, aluno não inserido na lista");
				} else {
					JOptionPane.showMessageDialog(null, "Aluno adicionado no final da lista: \n" + mensagem);
				}
				break;
			case 3:
				mensagem = lista.removeInicio();

				if (mensagem == " ") {
					JOptionPane.showMessageDialog(null, "Nenhum Aluno foi removido.");
				} else {
					JOptionPane.showMessageDialog(null, "Aluno removido do início da lista \n" + mensagem);
				}

				break;

			case 4:
				mensagem = lista.removeFinal();

				if (mensagem == " ") {
					JOptionPane.showMessageDialog(null, "Nenhum Aluno foi removido.");
				} else {
					JOptionPane.showMessageDialog(null, "Aluno removido do final da lista \n" + mensagem);
				}

				break;

			case 5:
				if (lista.listaVazia()) {
					JOptionPane.showMessageDialog(null, "A lista está vazia.");

				} else {
					JOptionPane.showMessageDialog(null, "A lista não está vazia.");
				}
				break;

			case 6:

				mensagem = lista.percorreLista();

				if (mensagem == " ") {
					JOptionPane.showMessageDialog(null, "A lista não possui informações.");
				} else {
					JOptionPane.showMessageDialog(null, "Relação de alunos da lista \n" + mensagem);
				}
				break;

			case 9:
				JOptionPane.showMessageDialog(null, "Programa finalizado, Até logo!");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida!");
				break;
			}
		}

	}

}
