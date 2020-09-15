package Ex03_Atividade_EstruturaDeDados;

public class Aluno{

	private int ra;
	private String nome;
	private String turma;
	private String semestre;
	private Aluno proximo;

	public Aluno(int ra, String nome, String turma, String semestre) {
		super();
		this.ra = ra;
		this.nome = nome;
		this.turma = turma;
		this.semestre = semestre;
		this.proximo = null;
	}

	public int getRa() {
		return ra;
	}

	public void setRa(int ra) {
		this.ra = ra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	
	public Aluno getProximo() {
		return proximo;
	}

	public void setProximo(Aluno proximo) {
		this.proximo = proximo;
	}

}
