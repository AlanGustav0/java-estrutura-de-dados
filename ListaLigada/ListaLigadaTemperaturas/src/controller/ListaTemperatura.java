package controller;


import javax.swing.JOptionPane;

public class ListaTemperatura {

	// Declaração de objetos da lista, neste caso criamos um objeto do tipo classe
	private NO inicio;

	// Método construtor da Lista Dinâmica
	public ListaTemperatura() {
		this.inicio = null;

	}

	public void adicionarInicio(double temperatura) {

		/*
		 * Para podermos inserir um novo elemento, é necessário criar um novo Nó, tendo
		 * em vista que a lista não possui tamanho pré-definido, por se tratar de uma
		 * alocação dinâmica de memória. Este novo Nó irá alocar e valor do elemento
		 * atual e "setar o valor do próximo elemento.
		 */
		NO novo = new NO();
		novo.setElemento(temperatura);
		novo.setProximo(inicio);

		// Caso o inicio (primeiro elemento esteja vazio, o novo elemento será o
		// primeiro da lista.
		if (inicio == null) {
			inicio = novo;
			JOptionPane.showMessageDialog(null, "A temperatura " + temperatura + "º foi adicionada no início da lista");

		} else {

			/*
			 * Caso contrário, criamos um elemento auxiliar para quardar o valor do início
			 * (com isso não perdemos referência) e então percorremos a lista, enquanto o
			 * valor da variável auxiliar seja diferente de nulo. Ao encontrar um elemento
			 * nulo, terminarmos o laço e então inserimos o novo valor no elemento
			 * encotrado. O elemento nulo após o último valor da lista.
			 */
			NO auxiliar;
			auxiliar = inicio;

			novo.setElemento(temperatura);
			novo.setProximo(inicio);
			inicio = novo;
			JOptionPane.showMessageDialog(null, "A temperatura " + temperatura + "º foi adicionada no início da lista");

		}

	}

	public void adicionarFinal(double temperatura) {

		// Caso o inicio esteja vazio, inserimos o elemento no incio da lista, que
		// consequentemente é o final.
		if (inicio == null) {
			NO novo = new NO();
			novo.setElemento(temperatura);
			inicio = novo;

		} else {

			// Caso contrário, percorremos a lista até encontrar um valor nulo, para
			// podermos adicionar no final.
			NO auxiliar = inicio;
			while (auxiliar.getProximo() != null) {
				auxiliar = auxiliar.getProximo();
			}

			// Criamos um novo espaço de memória (novo do tipo classe) que irá aloxar a
			// temperatura.
			NO novo = new NO();
			novo.setElemento(temperatura);
			auxiliar.setProximo(novo);

		}

	}

	public double removeInicio() {

		/*
		 * Aqui criamos uma variável que recebe o incício e outra com um valor de
		 * temperatura inválido. Dizemos que é um valor inválido pois está acima do zero
		 * absoluto. Através deste valor verificamos se a lista está vazia ou não.
		 */
		NO auxiliar = inicio;
		double elemento = -1000;

		// Caso esteja vazia, retornamos o valor de temperatura inválido
		if (inicio == null) {
			return elemento;

			// Caso contrário, a variável temperatura recebe o valor do elemento a ser
			// removido e o início recebe o próximo valor.
		} else {
			elemento = inicio.getElemento();
			inicio = inicio.getProximo();

		}

		return elemento;
	}

	public double removeFinal() {

		// Aqui criamos uma variável que servirá para verificar se a lisra está ou não
		// vazia
		double elemento = -1000;
		if (inicio == null) {
			return elemento;
		} else {

			/*
			 * Caso contrário, verificamos se a lista possui apenas 1 elemento, caso
			 * positivo, este elemento será removido, pois trata-se do final da lista.
			 */
			if (inicio.getProximo() == null) {
				elemento = inicio.getElemento();
				inicio = null;
				return elemento;

			} else {

				/*
				 * Não sendo o primeiro elemento, então criamos 2 variáveis auxiliares, ambas
				 * recebendo início. A primeira guarda o valor de início e a outra recebe o
				 * valor do proximo valor.
				 */
				NO auxiliar = inicio;
				NO auxiliar2 = inicio;

				while (auxiliar.getProximo() != null) {
					auxiliar2 = auxiliar;
					auxiliar = auxiliar.getProximo();
				}

				// quando chegamos no final da lista, a variável elemento recebe o último valor
				// encontrado e este espaço de memória passa a ser nulo.
				elemento = auxiliar.getElemento();
				auxiliar2.setProximo(null);
			}

		}

		return elemento;

	}

	public void escolhePosicao(double temperatura, int posicao) {

		// Primeiro criamos nosso Nó para inserir a temperatura recebido por parâmetro
		NO novo = new NO();
		novo.setElemento(temperatura);

		// Caso a lista esteja vazia
		if (inicio == null) {
			JOptionPane.showMessageDialog(null,
					"A operação não pode ser realizada, verifique a opção 7 do menu de opções.");
		} else {

			// caso contrário verificamos a primeira posição, então fazemos a chamada do
			// método de retirar no inicio
			if (posicao == 1) {
				adicionarInicio(temperatura);
			} else {

				// Caso contrário, crismo um contador para podermos mensurar o "tamanho" dessa
				// lista.
				NO auxiliar = inicio;
				int contador = 1;

				// então percorremos ela e incrementamos nosso contador
				while (auxiliar != null && contador < posicao - 1) {
					auxiliar = auxiliar.getProximo();
					contador++;
				}

				/*
				 * Se o contador for igual ao valor da posição - 1, quer dizer que chegamos até
				 * um número antes da posição escolhida Então o próximo número será o nosso novo
				 * valor. E o próximo valor após a posição que escolhemos, será a antiga posição
				 * onde agora está o valor novo.
				 */

				if (contador == posicao - 1) {
					novo.setProximo(auxiliar.getProximo());
					auxiliar.setProximo(novo);
					JOptionPane.showMessageDialog(null,
							"A temperatura " + temperatura + "º foi adicionada na posição " + posicao + " da lista");
				} else {

					/*
					 * Caso a posição não seja encontrada, imprimimos a mensagem de posição
					 * inválida. Esta posição será considerada inválida quando ela for maior que o
					 * tamanho da posição ou não estiver dentro do intervalo (tamanho) que a lista
					 * possui.
					 * 
					 */
					JOptionPane.showMessageDialog(null, "Posição inválida!");
				}
			}
		}
	}

	public double removePosicao(int posicao) {

		// criamos o espaço de memória auxiliar para guardar a referência de inicio
		NO auxiliar = inicio;
		// Variável maior que zero absoluto para retornar um valor "nulo" ou inválido.
		double elemento = -1000;
		// Contador para mensurar o tamanho da lista
		int contador = 1;

		// Se o início for nulo, a variável nula é retornada
		if (inicio == null) {

			return elemento;
		} else {
			// Se a posição escolhida for igual a 1, fazemos a chamada do método de retirar
			// no inicio.
			if (posicao == 1) {
				elemento = removeInicio();
			} else {

				// Caso contrário, percorremos a lista e incrementamos o contador
				while (auxiliar.getProximo() != null) {
					auxiliar = auxiliar.getProximo();
					contador++;
				}

				// Validamos este contador, se a posição for maior que o contador, ou a posição
				// for menor ou igual a 0 retornamos o elemento "nulo". (-2000)
				if (posicao > contador || posicao < 0 || posicao == 0) {
					elemento = -2000;
					return elemento;

					// Caso a posição for igual ao contador, estamos no final da lista, então
					// fazemos a chamada do método de retirar no final.
				} else if (posicao == contador) {
					return removeFinal();

				} else {

					/*
					 * Caso contrário, Criamos outro espaço de memoria para auxiliar na verificação
					 * da lista enquanto nosso contador dor menor que a posição, puxamos os valores
					 * até chegar a uma posição antes da posição escolhida
					 */
					NO auxiliarInicio = auxiliar;

					while (contador < posicao) {
						auxiliarInicio = auxiliar;
						auxiliar = auxiliar.getProximo();
						contador++;
					}

					/*
					 * Quando finalizamos o laço, nosso elemento recebe o valor da posição atual,
					 * que será a posição que foi escolhida para ser retirada E nossa variável
					 * auxiliarInicio recebe o próximo valor da variável auxiliar, ou seja, um valor
					 * nulo, assim nós anularmos a posição escolhida.
					 */
					elemento = auxiliar.getElemento();
					auxiliarInicio.setProximo(auxiliar.getProximo());

				}
			}
		}

		return elemento;

	}

	// Método para verificar se a lista está vazia
	public boolean listaVazia() {
		return (this.inicio == null);
	}

	public String toString() {

		/*
		 * Aqui criamos uma variável para armazanar a referência de incío e uma variável
		 * do tipo String para armazanar as informações da lista.
		 */

		String mostraLista = "";
		NO auxiliar = inicio;

		// Percorremos a lista e vamos concatenando os valores enquanto ela não encontra
		// um valor nulo.

		if (inicio == null) {
			mostraLista = "A lista ainda não possui nenhum elemento.";
		} else {

			while (auxiliar != null) {

				mostraLista += auxiliar.getElemento() + "\n";
				auxiliar = auxiliar.getProximo();

			}

		}

		// retornamos a variável com os valores concatenados
		return mostraLista;

	}

}
