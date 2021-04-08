package ArvoreAVL;

public class ArvoreAVL {

	private Elemento elemento;
	private ArvoreAVL direita;
	private ArvoreAVL esquerda;
	private int bal;

	// Aqui não precisariamos declarar null, uma vez que o construtor padrão já
	// realiza esta função
	// É apenas para ficar mais didático
	public ArvoreAVL() {
		this.elemento = null;
		this.direita = null;
		this.esquerda = null;
		this.bal = 0;
	}

	// Sobrecarga criando outro construtor
	public ArvoreAVL(Elemento elemento) {
		this.elemento = elemento;
		this.direita = null;
		this.esquerda = null;
		this.bal = 0;
		System.out.println("Criei uma árvore com elemento " + this.elemento.getValor());
	}

	// Metodos de verificacao e rotacao

	public ArvoreAVL verificaBalanceamento() {

		if (this.bal >= 2 || this.bal <= -2) {
			if (this.bal >= 2) {
				if (this.bal * this.direita.getBalanceamento() > 0) {
					System.out.println("Rotação Simples a Direita");
					return rotacaoSimplesDireita();
				} else {
					System.out.println("Rotação Dupla a Direita");
					return rotacaoDuplaDireita();
				}
			} else { // bal <= -2
				if (this.bal * this.esquerda.getBalanceamento() > 0) {
					System.out.println("Rotação Simples a Esquerda");
					return rotacaoSimplesEsquerda();
				} else {
					System.out.println("Rotação Dupla a Direita");
					return rotacaoDuplaEsquerda();
				}
			}
		}
		this.calcularBalanceamento();
		if (this.esquerda != null) {
			this.esquerda = this.esquerda.verificaBalanceamento();
		}
		if (this.direita != null) {
			this.direita = this.direita.verificaBalanceamento();
		}
		return this;
	}

	private ArvoreAVL rotacaoDuplaEsquerda() {
		ArvoreAVL arvore = this;
		ArvoreAVL filhoEsq = this.getEsquerda();
		ArvoreAVL filhoDoFilho = filhoEsq.getDireita();
		ArvoreAVL noInserido = filhoDoFilho.getEsquerda();
		// parte 1: alinhar os caras

		filhoEsq.setDireita(noInserido);
		filhoDoFilho.setEsquerda(filhoEsq);
		this.setEsquerda(filhoDoFilho);

		// parte 2: tornar o gilho a direita a nova raiz
		ArvoreAVL novoFilhoEsquerda = this.getEsquerda();
		arvore.setEsquerda(null);
		novoFilhoEsquerda.setDireita(arvore);
		return novoFilhoEsquerda;
	}

	private ArvoreAVL rotacaoSimplesEsquerda() {
		ArvoreAVL filhoEsq;
		ArvoreAVL filhoDoFilho = null;

		filhoEsq = this.getEsquerda();
		if (this.esquerda != null) {
			if (this.esquerda.getDireita() != null) {
				filhoDoFilho = filhoEsq.getDireita();
			}
		}
		filhoEsq.setDireita(this);
		this.setEsquerda(filhoDoFilho);
		return filhoEsq;
	}

	private ArvoreAVL rotacaoDuplaDireita() {
		ArvoreAVL arvore = this;
		ArvoreAVL filhoDir = this.getDireita();
		ArvoreAVL filhoDoFilho = filhoDir.getEsquerda();
		ArvoreAVL noInserido = filhoDoFilho.getDireita();
		// parte 1: alinhar os caras

		filhoDir.setEsquerda(noInserido);
		filhoDoFilho.setDireita(filhoDir);
		this.setDireita(filhoDoFilho);

		// parte 2: tornar o gilho a direita a nova raiz
		ArvoreAVL novoFilhoDireita = this.getDireita();
		arvore.setDireita(null);
		novoFilhoDireita.setEsquerda(arvore);
		return novoFilhoDireita;

	}

	private ArvoreAVL rotacaoSimplesDireita() {
		ArvoreAVL filhoDir;
		ArvoreAVL filhoDoFilho = null;

		filhoDir = this.getDireita();
		if (this.direita != null) {
			if (this.direita.getEsquerda() != null) {
				filhoDoFilho = filhoDir.getEsquerda();
			}
		}
		filhoDir.setEsquerda(this);
		this.setDireita(filhoDoFilho);
		return filhoDir;
	}

	// Métodos de controle
	public boolean isEmpty() {
		return this.elemento == null;
	}

	public ArvoreAVL inserir(Elemento novo) {

		if (isEmpty()) {
			this.elemento = novo;
		} else {
			ArvoreAVL novaArvore = new ArvoreAVL(novo);
			if (novo.getValor() < this.elemento.getValor()) {// vou inserir na descendencia esquerda
				if (this.esquerda == null) {// sou um nó folha?
					this.esquerda = novaArvore;
					System.out.println(
							"Inseri o elemento " + novo.getValor() + " à esquerda de " + this.elemento.getValor());
				} else {
					this.esquerda = this.esquerda.inserir(novo); // repassei a responsabilidade para a sub-árvore
																	// esquerda

				}
			} else if (novo.getValor() > this.elemento.getValor()) {// Na descendencia direita
				if (this.direita == null) {// sou um nó folha?
					this.direita = novaArvore;
					System.out.println(
							"Inseri o elemento " + novo.getValor() + " à direita de " + this.elemento.getValor());
				} else {
					this.direita = this.direita.inserir(novo);

				}

			}
		}

		return this;
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
	public ArvoreAVL remover(Elemento elemento) {
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
					// caso 4 - tenho filhos dos dois lados
				} else {
					// adotando a estratégia do maior dentre os menores
					ArvoreAVL auxiliar = this.esquerda;
					while (auxiliar.direita != null) {
						auxiliar = auxiliar.direita;
					}
					// troco os elemento da árvore
					// nó atual recebe elemento da auxiliar, maior dentre os menores
					// insiro lá embaixo no nó folha o elemento que será eliminado
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

	public int calculaAltura() {
		if (this.esquerda == null && this.direita == null) {// não tenho nenhum filho
			return 1;
		} else if (this.esquerda != null && this.direita == null) {
			return 1 + this.esquerda.calculaAltura();
		} else if (this.esquerda == null && this.direita != null) {
			return 1 + this.direita.calculaAltura();
		} else {
			return 1 + Math.max(this.esquerda.calculaAltura(), this.direita.calculaAltura());
		}

	}

	public void calcularBalanceamento() {
		if (this.esquerda == null && this.direita == null) {
			this.bal = 0;
		} else if (this.esquerda == null && this.direita != null) {
			this.bal = this.direita.calculaAltura() - 0;
		} else if (this.esquerda != null && this.direita == null) {
			this.bal = 0 - this.esquerda.calculaAltura();
		} else {
			this.bal = this.direita.calculaAltura() - this.esquerda.calculaAltura();
		}

		if (this.direita != null) {
			this.direita.calcularBalanceamento();
		}

		if (this.esquerda != null) {
			this.esquerda.calcularBalanceamento();
		}
	}

	// gets e sets
	public Elemento getElemento() {
		return elemento;
	}

	public void setElemento(Elemento elemento) {
		this.elemento = elemento;
	}

	public ArvoreAVL getDireita() {
		return direita;
	}

	public void setDireita(ArvoreAVL direita) {
		this.direita = direita;
	}

	public ArvoreAVL getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(ArvoreAVL esquerda) {
		this.esquerda = esquerda;
	}

	public int getBalanceamento() {
		return bal;
	}

	public void setBalanceamento(int bal) {
		this.bal = bal;
	}

	// Mmetodo de depuração

	public String printArvore(int level) {
		String str = toString() + "\n";
		for (int i = 0; i < level; i++) {
			str += "\t";
		}
		if (this.esquerda != null) {
			str += "+-ESQ: " + this.esquerda.printArvore(level + 1);
		} else {
			str += "+-ESQ: NULL";
		}
		str += "\n";

		for (int i = 0; i < level; i++) {
			str += "\t";
		}
		if (this.direita != null) {

			str += "+-DIR: " + this.direita.printArvore(level + 1);
		} else {
			str += "+-DIR: NULL";
		}
		str += "\n";
		return str;
	}

	public String toString() {
		return "[" + this.elemento.getValor() + "] (" + this.bal + ")";
	}

}
