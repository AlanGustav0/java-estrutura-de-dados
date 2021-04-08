package ArvoreBinaria;

public class Arvore {

	private Elemento elemento;
	private Arvore direita;
	private Arvore esquerda;

	// Aqui não precisariamos declarar null, uma vez que o construtor padrão já
	// realiza esta função
	// É apenas para ficar mais didático
	public Arvore() {
		this.elemento = null;
		this.direita = null;
		this.esquerda = null;
	}

	// Sobrecarga criando outro construtor
	public Arvore(Elemento elemento) {
		this.elemento = elemento;
		this.direita = null;
		this.esquerda = null;
		System.out.println("Criei uma árvore com elemento " + this.elemento.getValor());
	}

	// Métodos de controle
	public boolean isEmpty() {
		return this.elemento == null;
	}

	public void inserir(Elemento novo) {

		if (isEmpty()) {
			this.elemento = novo;
		} else {
			Arvore novaArvore = new Arvore(novo);
			if (novo.getValor() < this.elemento.getValor()) {// vou inserir na descendencia esquerda
				if (this.esquerda == null) {// sou um nó folha?
					this.esquerda = novaArvore;
					System.out.println(
							"Inseri o elemento " + novo.getValor() + " à esquerda de " + this.elemento.getValor());
				} else {
					this.esquerda.inserir(novo); // repassei a responsabilidade para a sub-árvore esquerda

				}
			} else if (novo.getValor() > this.elemento.getValor()) {// Na descendencia direita
				if (this.direita == null) {// sou um nó folha?
					this.direita = novaArvore;
					System.out.println(
							"Inseri o elemento " + novo.getValor() + " à direita de " + this.elemento.getValor());
				} else {
					this.direita.inserir(novo);

				}

			}
		}
	}

	public boolean busca(int valor) {
		if (isEmpty()) {
			return false;
		}

		if (this.elemento.getValor() == valor) {
			return true;
		} else {
			if (valor < this.elemento.getValor()) {
				if (this.esquerda == null) {
					return false;
				} else {
					return this.esquerda.busca(valor);// repassei a responsabilidade para a subarvore esquerda
				}
			} else if (valor > this.elemento.getValor()) {
				if (this.direita == null) {
					return false;
				} else {
					return this.direita.busca(valor);
				}
			}
			return false;
		}
	}

	public void imprimePreOrdem() {

		if (!isEmpty()) {
			System.out.print(this.elemento.getValor() + " ");

			if (this.esquerda != null) {
				this.esquerda.imprimePreOrdem();
			}
			if (this.direita != null) {
				this.direita.imprimePreOrdem();
			}
		}
	}

	public void imprimeInOrdem() {
		if (!isEmpty()) {
			if (this.esquerda != null) {
				this.esquerda.imprimeInOrdem();
			}
			System.out.print(this.elemento.getValor() + " ");

			if (this.direita != null) {
				this.direita.imprimeInOrdem();
			}

		}
	}

	public void imprimePosOrdem() {
		if (!isEmpty()) {
			if (this.direita != null) {
				this.direita.imprimePosOrdem();
			}
			if (this.esquerda != null) {
				this.esquerda.imprimePosOrdem();
			}
			System.out.print(this.elemento.getValor() + " ");
		}
	}

	public void ImprimeInOdermInvertida() {
		if (!isEmpty()) {
			if (this.direita != null) {
				this.direita.ImprimeInOdermInvertida();
			}
			System.out.print(this.elemento.getValor() + " ");
			if (this.esquerda != null) {
				this.esquerda.ImprimeInOdermInvertida();
			}
		}
	}

	// removendo nós da arvore
	public Arvore remover(Elemento elemento) {
		// primeiro caso - elemento encontrado
		if (this.elemento.getValor() == elemento.getValor()) {
			// caso mais simples - o elemento está em um nó folha
			if (this.direita == null && this.esquerda == null) {
				return null;
			} else {
				// caso 2 - eu tenho filhos a esquerda e não tenho filhos a direita
				if (this.esquerda != null && this.direita == null) {
					return this.esquerda;
					// caso 3 - tenho filho a direita e não tenho a esquerda
				} else if (this.direita != null && this.esquerda == null) {
					return this.direita;
					//caso 4 - tenho filhos dos dois lados
				}else {
					//adotando a estratégia do maior dentre os menores
					Arvore auxiliar = this.esquerda;
					while(auxiliar.direita != null) {
						auxiliar = auxiliar.direita;
					}
					//troco os elemento da árvore
					//nó atual recebe elemento da auxiliar, maior dentre os menores
					//insiro lá embaixo no nó folha o elemento que será eliminado
					this.elemento = auxiliar.getElemento(); 
					auxiliar.setElemento(elemento);
					
					this.esquerda = esquerda.remover(elemento);
				}

			}

		} else if (elemento.getValor() < this.elemento.getValor()) {
			// delegar a responsabilidade para a sub-árvore da esquerda
			this.esquerda = this.esquerda.remover(elemento);
		} else if (elemento.getValor() > this.elemento.getValor()) {
			// delegar a responsabilidade para a sub-árvore da direita
			this.direita = this.direita.remover(elemento);
		}

		return this;

	}

	// gets e sets
	public Elemento getElemento() {
		return elemento;
	}

	public void setElemento(Elemento elemento) {
		this.elemento = elemento;
	}

	public Arvore getDireita() {
		return direita;
	}

	public void setDireita(Arvore direita) {
		this.direita = direita;
	}

	public Arvore getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(Arvore esquerda) {
		this.esquerda = esquerda;
	}

}
