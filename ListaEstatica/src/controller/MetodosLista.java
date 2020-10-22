package controller;

import javax.swing.JOptionPane;

import entity.AtributosCurso;

public class MetodosLista {

	private AtributosCurso dados[];
	private int tamanho;

	public MetodosLista() {
		dados = new AtributosCurso[5];
		tamanho = 0;
	}

	public boolean listaVazia() {

		if (tamanho <= 0) {
			return true;
		}

		return false;
	}

	public boolean listaCheia() {

		if (tamanho > dados.length) {
			return true;
		}

		return false;
	}

	public String adicionaInicio(int id, String nome, String areaCurso, int qtdSemestres, String periodo) {

		String mensagem = null;

		if (tamanho == dados.length) {
			return mensagem;
		}

		if (tamanho < dados.length) {

			for (int i = tamanho; i > 0; i--) {
				dados[i] = dados[i - 1];
			}

			dados[0] = new AtributosCurso(id, nome, areaCurso, qtdSemestres, periodo);
			tamanho++;

			for (int i = 0; i < dados.length; i++) {
				if (dados[i] != null) {
					mensagem += "id: " + dados[i].getId() + "\nNome: " + dados[i].getNome() + "\nCurso: "
							+ dados[i].getAreaCurso() + "\nSemestres: " + dados[i].getQtdSemestres() + "\nPeríodo: "
							+ dados[i].getPeriodo();
				}

			}

			return mensagem;
		}

		return mensagem;

	}

	public String adicionaFinal(int id, String nome, String areaCurso, int qtdSemestres, String periodo) {

		String mensagem = null;

		if (tamanho == dados.length) {
			return mensagem;
		}

		if (tamanho < dados.length) {
			dados[tamanho] = new AtributosCurso(id, nome, areaCurso, qtdSemestres, periodo);
			;
			tamanho++;
			for (int i = 0; i < dados.length; i++) {
				if (dados[i] != null) {
					mensagem += "Id: " + dados[i].getId() + "\nNome: " + dados[i].getNome() + "\nCurso: "
							+ dados[i].getAreaCurso() + "\nSemestres: " + dados[i].getQtdSemestres() + "\nPeríodo: "
							+ dados[i].getPeriodo();
				}
			}

			return mensagem;
		}

		return mensagem;
	}

	public String adicionaPosicaoEspecifica(int id, String nome, String areaCurso, int qtdSemestres, String periodo,
			int posicao) {

		int i;
		String mensagem = null;

		if (tamanho == dados.length) {
			return mensagem;
		}

		if ((tamanho < dados.length) && (posicao < tamanho + 1) && (posicao >= 0)) {

			for (i = tamanho; i >= posicao; i--) {
				dados[i] = dados[i - 1];

			}
			dados[i] = new AtributosCurso(id, nome, areaCurso, qtdSemestres, periodo);
			tamanho++;
			mensagem += "Id: " + dados[i].getId() + "\nNome: " + dados[i].getNome() + "\nCurso: "
					+ dados[i].getAreaCurso() + "\nSemestres: " + dados[i].getQtdSemestres() + "\nPeríodo: "
					+ dados[i].getPeriodo();

			return mensagem;

		}

		return mensagem;
	}

	public String removeInicio() {

		String mensagem = null;

		if (tamanho >= 1) {

			mensagem += "Id: " + dados[0].getId() + "\nNome: " + dados[0].getNome() + "\nCurso: "
					+ dados[0].getAreaCurso() + "\nSemetres: " + dados[0].getQtdSemestres() + "\nPeríodo: "
					+ dados[0].getPeriodo();

			for (int i = 1; i < tamanho; i++) {
				dados[i - 1] = dados[i];
			}

			tamanho--;

		}
		return mensagem;

	}

	public String removeFinal() {

		String mensagem = null;

		if (tamanho >= 1) {

			mensagem += "Id: " + dados[tamanho - 1].getId() + "\nNome: " + dados[tamanho - 1].getNome() + "\nCurso: "
					+ dados[tamanho - 1].getAreaCurso() + "\nSemetres: " + dados[tamanho - 1].getQtdSemestres()
					+ "\nPeríodo: " + dados[tamanho - 1].getPeriodo();

			for (int i = 0; i < tamanho; i++) {
				if (i == tamanho - 1)
					tamanho--;
			}

		}
		return mensagem;

	}

	public String removePosicaoEspecifica(int posicao) {

		String mensagem = null;

		if (posicao < tamanho && tamanho > 1) {
			mensagem += "Id: " + dados[tamanho - 1].getId() + "\nNome: " + dados[tamanho - 1].getNome() + "\nCurso: "
					+ dados[tamanho - 1].getAreaCurso() + "\nSemetres: " + dados[tamanho - 1].getQtdSemestres()
					+ "\nPeríodo: " + dados[tamanho - 1].getPeriodo();

			for (int i = posicao; i < tamanho - 1; i++) {
				dados[i] = dados[i + 1];
			}

			tamanho--;
		}

		return mensagem;

	}

	public String percorre() {
		String mensagem = null;

		for (int i = 0; i < tamanho; i++) {
			mensagem += "\nId: " + dados[i].getId() + "\nNome: " + dados[i].getNome() + "\nCurso: "
					+ dados[i].getAreaCurso() + "\nSemetres: " + dados[i].getQtdSemestres() + "\nPeríodo: "
					+ dados[i].getPeriodo() + "\n --------------------";
		}
		return mensagem;
	}

}
