package Ex02_Atividade_EstruturaDeDados;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {

		ListaTemperatura lista = new ListaTemperatura();

		int opcao = 0;
		double temperatura = 0;
		int posicao = 0;
		double elemento = 0;
		
		/*
		 * ********************************************Teste de Mesa**************************************************************
		 * 1 - Opção 1 - Adicionar no início temperatura 32  : Saída ["A temperatura 32° foi adicionada no início da lista"]
		 * 2 - Opção 2 - Adicionar no Final temperatura -10  : Saída ["A temperatura -10° foi adicionada no final da lista"]
		 * 3 - Opção 5 - Adicionar em posição específica temperatura 15 posição 1  : Saída ["A temperatura 15° foi adicionada no início da lista"]
		 * 4 - Opção 4 - Remove Final da lista : Saída ["A temperatura -10° foi removida do final da lista"]
		 * 5 - Opção 7 - Verificar se lista está vazia  : Saída ["A lista não está vazia"]
		 */
		
		

		while (opcao != 9) {

			opcao = Integer.parseInt(JOptionPane.showInputDialog(
					"***Lista de Temperaturas***\n Escolha a opção desejada \n ---------------------\n "
							+ "1-Adicionar no início\n 2-Adicionar no Final\n 3-Remover no início\n 4-Remover no Final\n "
							+ "5-Adiciona posição específica\n 6-Remover posição específica\n 7-Verificar se lista está vazia\n 8-Mostrar lista atual\n 9-Finalizar"));
			switch (opcao) {
			case 1:
				temperatura = Double.parseDouble(JOptionPane.showInputDialog("Insira a temperatura desejada:"));
				lista.adicionarInicio(temperatura);
				break;

			case 2:
				temperatura = Double.parseDouble(JOptionPane.showInputDialog("Insira a temperatura desejada:"));
				lista.adicionarFinal(temperatura);
				JOptionPane.showMessageDialog(null,
						"A temperatura " + temperatura + "º foi adicionada no final da lista");
				break;
			case 3:
				elemento = lista.removeInicio();

				if (elemento < -283) {
					JOptionPane.showMessageDialog(null,
							"Nenhum valor foi removido, verifique a opção 7 do menu de opções.");
				} else {
					JOptionPane.showMessageDialog(null,
							"A temperatura " + elemento + "º foi removida do inicio da lista");
				}

				break;

			case 4:
				elemento = lista.removeFinal();
				if (elemento < -283) {
					JOptionPane.showMessageDialog(null,
							"Nenhum valor foi removido, verifique a opção 7 do menu de opções.");
				} else {
					JOptionPane.showMessageDialog(null,
							"A temperatura " + elemento + "º foi removida do final da lista");
				}

				break;

			case 5:
				temperatura = Double.parseDouble(JOptionPane.showInputDialog("Insira a temperatura desejada:"));
				posicao = Integer.parseInt(JOptionPane.showInputDialog("Insira a posição desejada:"));
				lista.escolhePosicao(temperatura, posicao);
				break;

			case 6:
				posicao = Integer.parseInt(JOptionPane.showInputDialog("Insira a posição desejada:"));
				elemento = lista.removePosicao(posicao);

				if (elemento == -1000) {
					JOptionPane.showMessageDialog(null,
							"A operação não pode ser realizada, verifique a opção 7 do menu de opções.");
				} else if (elemento == -2000)
					JOptionPane.showMessageDialog(null, "Posição inválida!");
				else {
					JOptionPane.showMessageDialog(null,
							"A temperatura " + elemento + "º foi removida do final da lista");
				}
				break;

			case 7:
				if (lista.listaVazia()) {
					JOptionPane.showMessageDialog(null, "A lista está vazia.");

				} else {
					JOptionPane.showMessageDialog(null, "A lista não está vazia.");
				}
				break;

			case 8:
				JOptionPane.showMessageDialog(null, "Relação de temperaturas da lista \n" + lista);
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
