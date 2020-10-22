package entity;

public class AtributosCurso {
	
	private int id;
	private String nome;
	private String areaCurso;
	private int qtdSemestres;
	private String periodo;
	private AtributosCurso proximo;

	public AtributosCurso(int id, String nome, String areaCurso, int qtdSemestres, String periodo) {
		this.id = id;
		this.nome = nome;
		this.areaCurso = areaCurso;
		this.qtdSemestres = qtdSemestres;
		this.periodo = periodo;
		proximo = null;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAreaCurso() {
		return areaCurso;
	}

	public void setAreaCurso(String areaCurso) {
		this.areaCurso = areaCurso;
	}

	public int getQtdSemestres() {
		return qtdSemestres;
	}

	public void setQtdSemestres(int qtdSemestres) {
		this.qtdSemestres = qtdSemestres;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public AtributosCurso getProximo() {
		return proximo;
	}

	public void setProximo(AtributosCurso proximo) {
		this.proximo = proximo;
	}
	
	

}
