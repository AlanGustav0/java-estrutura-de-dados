package Ex03_Atividade_EstruturaDeDados;

import javax.swing.JOptionPane;

public class ListaAlunos {

	private Aluno inicio;

	public ListaAlunos() {
		this.inicio = null;
	}

	public void adicionaInicio(int ra, String nome, String turma, String semestre) {
		/*
		 * Para podermos inserir um novo aluno, é necessário criar um novo elemento com
		 * as características do aluno, tendo em vista que a lista não possui tamanho
		 * pré-definido, por se tratar de uma alocação dinâmica de memória. Este novo
		 * elemento irá alocar os dados do aluno.
		 * 
		 */
		Aluno novo = new Aluno(ra, nome, turma, semestre);

		// Caso o inicio (primeiro elemento esteja vazio, o novo elemento será o
		// primeiro da lista.
		if (inicio == null) {
			inicio = novo;
			JOptionPane.showMessageDialog(null, "O aluno " + nome + " foi adicionado no início da lista");

		} else {

			/*
			 * Caso contrário, criamos um elemento auxiliar para quardar o valor do início
			 * (com isso não perdemos referência) e então percorremos a lista, enquanto o
			 * valor da variável auxiliar seja diferente de nulo. Ao encontrar um elemento
			 * nulo, terminarmos o laço e então inserimos o novo aluno no elemento
			 * encotrado. O elemento nulo após o último valor da lista.
			 */
			Aluno auxiliar;
			auxiliar = inicio;

			novo.setProximo(inicio);
			inicio = novo;
			JOptionPane.showMessageDialog(null, "O aluno " + nome + " foi adicionada no início da lista");

		}
	}

	public void adicionaFinal(int ra, String nome, String turma, String semestre) {

		// Caso a lista esteja vazia, adicionamos o valor no incio, que será também o
		// final
		if (inicio == null) {
			Aluno novo = new Aluno(ra, nome, turma, semestre);
			inicio = novo;
		} else {

			// Caso contrário, criamos um elemento auxiliar para guardar a referencia
			Aluno auxiliar = inicio;

			// Percorremos a lista até chegar ao final dela, onde o próximo elemento após o
			// último será nulo
			while (auxiliar.getProximo() != null) {
				auxiliar = auxiliar.getProximo();
			}

			// Então criamos um "novo aluno" para armazenar as informações passadas por
			// parâmetro.
			Aluno novo = new Aluno(ra, nome, turma, semestre);

			// E inserimos este novo valor ao elemento após o último valor da variável
			// auxiliar (que estava nulo).
			auxiliar.setProximo(novo);
		}

	}

	public String removeInicio() {

		String aluno = null;

		// Verificamos se a lista está vazia, caso esteja retornamos um valor nulo.
		if (inicio == null) {
			return aluno;
		} else {

			// Caso contrário, o início recebe o próximo valor após ele, e retornamos o
			// valor que estava no inicio.
			Aluno auxiliar = inicio;
			aluno = auxiliar.getNome();
			inicio = inicio.getProximo();
		}

		return aluno;
	}

	public String removeFinal() {

		String aluno = null;

		// Verificando se o inicio é ou não nulo
		if (inicio == null) {
			return aluno;
		} else {

			// Verificando se o valor após ao inicio é nulo, caso seja, a lista possui
			// apenas 1 elemento
			if (inicio.getProximo() == null) {
				aluno = inicio.getNome();
				inicio = null;
			} else {

				/*
				 * Caso contrário, criamos 2 variáveis auxiliares para percorre a lista até o
				 * final dela, auxiliarBackup armazena o valor antes do final e a auxiliar
				 * receberá os dados do final. Quando terminamos de percorrer a lista a variável
				 * aluno receberá o nome do último aluno e a auxiliarBackup receberá o seu
				 * próximo valor nulo.
				 */
				Aluno auxiliar = inicio;
				Aluno auxiliarBackup = inicio;

				while (auxiliar.getProximo() != null) {
					auxiliarBackup = auxiliar;
					auxiliar = auxiliar.getProximo();
				}

				aluno = auxiliar.getNome();
				auxiliarBackup.setProximo(null);
			}

		}

		return aluno;
	}

	public String removeMeio() {

		//Aqui declaramos as variáveis que iremos utilizar
		Aluno auxiliar = inicio;
		String aluno = null;
		int tamanho = 1;
		int inicia = 0;
		int meio = 0;

		//Verificamos se a lista está vazia
		if (inicio == null) {
			return aluno;
		} else {

			//Verificamos se o próximo elemento após o início está vazio
			if (inicio.getProximo() == null) {
				aluno = inicio.getNome();
				inicio = null;

			} else {

				/*Caso contrário, criamos 2 variáveis auziliares
				 * 
				 * auxiliarBackup - usamos para percorrer a lista e fazer o incremento da variável contador, com isso temos o tamanho da lista
				 * 
				 * auxiliarAluno - usaremos para percorre a lista desde o início até a metade
				 */
				Aluno auxiliarBackup = inicio;
				Aluno auxiliarAluno = inicio;

				//Percorrendo a lista inteira
				while (auxiliarBackup != null) {
					auxiliarBackup = auxiliarBackup.getProximo();
					tamanho++;
				}

				//Para encontrar o meio da lista, recebemos na variável meio o valor do tamanho da lista divido por 2
				meio = tamanho / 2;

				/*A veriável "inicia" foi criada para marcar o incio da lista, iremos percorrer a lista até chegar no valor do meio - 1
				 * Afinal, quando chegarmos neste valor, iremos remover o valor após ele, ou seja, o valor do meio.
				 * 
				 * A variável auciliarAluno está sendo utilizada para guardar um valor do meio.
				 */
				while (inicia < meio - 1) {
					auxiliarAluno = auxiliar;
					auxiliar = auxiliar.getProximo();
					inicia++;
				}

				/*Caso ambos valores sejam iguais, aluno receberá o nome do próximo aluno (aluno do meio) e a variável auxiliarAluno receberá
				 * o valor após ela, excluindo assim o valor do meio que anteriormente havia sido armazenado nela.
				 */
				
				if (inicia == meio - 1) {
					aluno = auxiliar.getNome();
					auxiliarAluno.setProximo(auxiliar.getProximo());
				} else {
					aluno = " ";
				}

			}

		}

		return aluno;
	}

	//Método que verifica se a lista está vazia
	public boolean listaVazia() {
		return (inicio == null);
	}

	public String toString() {

		/*
		 * Aqui criamos uma variável para armazanar a referência de incío e uma variável
		 * do tipo String para armazanar as informações da lista.
		 */

		String mostraLista = "";
		Aluno auxiliar = inicio;

		// Percorremos a lista e vamos concatenando os valores enquanto ela não encontra
		// um valor nulo.

		if (inicio == null) {
			mostraLista = "A lista ainda não possui nenhum aluno.";
		} else {

			while (auxiliar != null) {

				mostraLista += "RA: " + auxiliar.getRa() + "\n";
				mostraLista += "Nome: " + auxiliar.getNome() + "\n";
				mostraLista += "Turma: " + auxiliar.getTurma() + "\n";
				mostraLista += "Semestre: " + auxiliar.getSemestre() + "\n";
				mostraLista += "---------------------" + "\n";
				auxiliar = auxiliar.getProximo();

			}

		}

		// retornamos a variável com os valores concatenados
		return mostraLista;

	}

}
