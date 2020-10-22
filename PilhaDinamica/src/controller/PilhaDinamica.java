package controller;

import entity.AtributosCurso;

public class PilhaDinamica {

	private AtributosCurso topo;

	public PilhaDinamica() {
		topo = null;
	}

	public String adiciona(int id, String nome, String areaCurso, int qtdSemestres, String periodo) {

		String mensagem = " ";

		if (topo == null) {
			AtributosCurso novo = new AtributosCurso(id, nome, areaCurso, qtdSemestres, periodo);
			mensagem += "id: " + novo.getId() + "\nNome: " + novo.getNome() + "\nCurso: " + novo.getAreaCurso()
					+ "\nSemestres: " + novo.getQtdSemestres() + "\nPeríodo: " + novo.getPeriodo();

			novo.setProximo(topo);
			topo = novo;
		} else {
			AtributosCurso auxiliar = topo;

			while (auxiliar.getProximo() != null) {
				auxiliar = auxiliar.getProximo();
			}

			AtributosCurso novo = new AtributosCurso(id, nome, areaCurso, qtdSemestres, periodo);
			mensagem += "id: " + novo.getId() + "\nNome: " + novo.getNome() + "\nCurso: " + novo.getAreaCurso()
					+ "\nSemestres: " + novo.getQtdSemestres() + "\nPeríodo: " + novo.getPeriodo();

			auxiliar.setProximo(novo);

		}

		return mensagem;

	}

	public String remove() {

		AtributosCurso novo;
		String mensagem = " ";

		if (topo == null) {
			return mensagem;
		} else if (topo.getProximo() == null) {
			novo = topo;
			mensagem += "id: " + novo.getId() + "\nNome: " + novo.getNome() + "\nCurso: " + novo.getAreaCurso()
					+ "\nSemestres: " + novo.getQtdSemestres() + "\nPeríodo: " + novo.getPeriodo();
			topo = null;
			return mensagem;
		} else {
			AtributosCurso auxiliar = topo;
			AtributosCurso auxiliar2 = auxiliar;

			while (auxiliar.getProximo() != null) {
				auxiliar2 = auxiliar;
				auxiliar = auxiliar.getProximo();
			}

			novo = auxiliar;
			mensagem += "id: " + novo.getId() + "\nNome: " + novo.getNome() + "\nCurso: " + novo.getAreaCurso()
					+ "\nSemestres: " + novo.getQtdSemestres() + "\nPeríodo: " + novo.getPeriodo();

			auxiliar2.setProximo(null);

		}
		return mensagem;

	}

	public boolean verificaPilha() {
		return this.topo == null;
	}

	public String percorrePilha() {

		String mensagem = " ";
		AtributosCurso auxiliar = topo;

		while (auxiliar != null) {
			mensagem += "\nid: " + auxiliar.getId() + "\nNome: " + auxiliar.getNome() + "\nCurso: "
					+ auxiliar.getAreaCurso() + "\nSemestres: " + auxiliar.getQtdSemestres() + "\nPeríodo: "
					+ auxiliar.getPeriodo() + "\n-----------------";

			auxiliar = auxiliar.getProximo();

		}

		return mensagem;

	}

}
