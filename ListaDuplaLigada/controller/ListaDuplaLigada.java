package controller;

import entity.AtributosCurso;

public class ListaDuplaLigada {

	private AtributosCurso inicio;
	private String resultado;

	// Método construtor
	public ListaDuplaLigada() {
		inicio = null;

	}

	// Método para adicionar elemento no início da lista
	public String adicionaInicio(int id, String nome, String areaCurso, int qtdSemestres, String periodo) {

		String mensagem = " ";

		AtributosCurso novo = new AtributosCurso(id, nome, areaCurso, qtdSemestres, periodo);

		if (inicio != null) {
			novo.setProximo(inicio);
			mensagem += "id: " + novo.getId() + "\nNome: " + novo.getNome() + "\nCurso: " + novo.getAreaCurso()
					+ "\nSemestres: " + novo.getQtdSemestres() + "\nPeríodo: " + novo.getPeriodo();
			inicio.setAnterior(novo);

		}else {
			inicio = novo;
			mensagem += "id: " + novo.getId() + "\nNome: " + novo.getNome() + "\nCurso: " + novo.getAreaCurso()
			+ "\nSemestres: " + novo.getQtdSemestres() + "\nPeríodo: " + novo.getPeriodo();
		}

		
		return mensagem;

	}

	// Método responsável por adicionar elemento no final da lista
	public String adicionaFinal(int id, String nome, String areaCurso, int qtdSemestres, String periodo) {
		AtributosCurso novo = new AtributosCurso(id, nome, areaCurso, qtdSemestres, periodo);

		String mensagem = " ";

		if (inicio == null) {
			inicio = novo;
			mensagem += "id: " + novo.getId() + "\nNome: " + novo.getNome() + "\nCurso: " + novo.getAreaCurso()
					+ "\nSemestres: " + novo.getQtdSemestres() + "\nPeríodo: " + novo.getPeriodo();
			inicio.setAnterior(novo);

			novo.setProximo(null);
			novo.setAnterior(null);
		} else {
			AtributosCurso auxiliar = buscaUltimo(inicio);
			auxiliar.setProximo(novo);
			novo.setAnterior(auxiliar);
			novo.setProximo(null);

			mensagem += "id: " + novo.getId() + "\nNome: " + novo.getNome() + "\nCurso: " + novo.getAreaCurso()
					+ "\nSemestres: " + novo.getQtdSemestres() + "\nPeríodo: " + novo.getPeriodo();

		}
		return mensagem;

	}

	public AtributosCurso buscaUltimo(AtributosCurso auxiliar) {

		if (auxiliar.getProximo() == null) {
			return auxiliar;
		}

		return buscaUltimo(auxiliar.getProximo());

	}

	// Método responsável por remover elemento do início da lista
	public String removeInicio() {

		String mensagem = " ";

		if (listaVazia() == true) {
			return mensagem;
		} else {

			AtributosCurso novo = inicio;
			inicio = inicio.getProximo();

			mensagem += "id: " + novo.getId() + "\nNome: " + novo.getNome() + "\nCurso: " + novo.getAreaCurso()
					+ "\nSemestres: " + novo.getQtdSemestres() + "\nPeríodo: " + novo.getPeriodo();

			if (inicio != null) {
				inicio.setAnterior(null);
			}

		}
		return mensagem;
	}

	// Método para remover elemento do final da lista
	public String removeFinal() {

		String mensagem = " ";

		if (listaVazia() == true) {
			return mensagem;
		} else if (inicio.getProximo() == null) {
			AtributosCurso novo = inicio;
			mensagem += "id: " + novo.getId() + "\nNome: " + novo.getNome() + "\nCurso: " + novo.getAreaCurso()
					+ "\nSemestres: " + novo.getQtdSemestres() + "\nPeríodo: " + novo.getPeriodo();

			inicio = null;

			return mensagem;

		} else {

			AtributosCurso auxiliar = buscaElemento(inicio, inicio);
			AtributosCurso novo = auxiliar.getProximo();
			mensagem += "id: " + novo.getId() + "\nNome: " + novo.getNome() + "\nCurso: " + novo.getAreaCurso()
					+ "\nSemestres: " + novo.getQtdSemestres() + "\nPeríodo: " + novo.getPeriodo();

			auxiliar.setProximo(null);
		}
		return mensagem;
	}

	public AtributosCurso buscaElemento(AtributosCurso auxiliar, AtributosCurso auxiliar2) {

		if (auxiliar.getProximo() == null) {
			return auxiliar2;
		}

		return buscaElemento(auxiliar.getProximo(), auxiliar);
	}

	// Método para verificar se lista está vazia
	public boolean listaVazia() {
		return (this.inicio == null);
	}

	// Método para percorrer e mostrar a lista
	public String percorreLista() {

		String mensagem = " ";
		AtributosCurso auxiliar = inicio;

		mensagem = ConcatenaRec(auxiliar, mensagem);

		return mensagem;
	}

	public String ConcatenaRec(AtributosCurso auxiliar, String mensagem) {

		if (auxiliar != null) {
			mensagem += "\nid: " + auxiliar.getId() + "\nNome: " + auxiliar.getNome() + "\nCurso: "
					+ auxiliar.getAreaCurso() + "\nSemestres: " + auxiliar.getQtdSemestres() + "\nPeríodo: "
					+ auxiliar.getPeriodo() + "\n-------------";

			return ConcatenaRec(auxiliar.getProximo(), mensagem);

		}
		return mensagem;

	}

}
