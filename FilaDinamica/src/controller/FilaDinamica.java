package controller;

import entity.AtributosCurso;

public class FilaDinamica {

	private AtributosCurso inicio;
	private AtributosCurso proximo;

	public FilaDinamica() {
		inicio = null;
		proximo = null;
	}

	public String adiciona(int id, String nome, String areaCurso, int qtdSemestres, String periodo) {

		AtributosCurso novo;
		String mensagem = " ";

		if (inicio == null) {
			novo = new AtributosCurso(id, nome, areaCurso, qtdSemestres, periodo);

			mensagem += "id: " + novo.getId() + "\nNome: " + novo.getNome() + "\nCurso: " + novo.getAreaCurso()
					+ "\nSemestres: " + novo.getQtdSemestres() + "\nPeríodo: " + novo.getPeriodo();

			inicio = novo;
		} else {

			AtributosCurso auxiliar = inicio;

			while (auxiliar.getProximo() != null) {
				auxiliar = auxiliar.getProximo();
			}
			novo = new AtributosCurso(id, nome, areaCurso, qtdSemestres, periodo);
			mensagem += "id: " + novo.getId() + "\nNome: " + novo.getNome() + "\nCurso: " + novo.getAreaCurso()
					+ "\nSemestres: " + novo.getQtdSemestres() + "\nPeríodo: " + novo.getPeriodo();

			auxiliar.setProximo(novo);

		}

		return mensagem;

	}

	public String remove() {

		String mensagem = " ";

		if (inicio == null) {
			return mensagem;

		} else {
			AtributosCurso novo;
			novo = inicio;
			mensagem += "id: " + novo.getId() + "\nNome: " + novo.getNome() + "\nCurso: " + novo.getAreaCurso()
					+ "\nSemestres: " + novo.getQtdSemestres() + "\nPeríodo: " + novo.getPeriodo();

			inicio = inicio.getProximo();
		}
		return mensagem;

	}

	public boolean verificaFila() {
		return this.inicio == null;
	}

	public String percorreFila() {

		String mensagem = " ";
		AtributosCurso auxiliar = inicio;

		while (auxiliar != null) {

			mensagem += "\nid: " + auxiliar.getId() + "\nNome: " + auxiliar.getNome() + "\nCurso: "
					+ auxiliar.getAreaCurso() + "\nSemestres: " + auxiliar.getQtdSemestres() + "\nPeríodo: "
					+ auxiliar.getPeriodo() + "\n-----------------";

			auxiliar = auxiliar.getProximo();
		}

		return mensagem;

	}

}
