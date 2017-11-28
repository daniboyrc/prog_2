public class Aluno {
	
	private String matricula;
	private String nome;
	private String curso;
	
	
	public Aluno(String nome, String matricula, String curso) {
		this.nome = nome;
		this.matricula = matricula;
		this.curso = curso;
	}
	
	public String getMatricula() {
		return this.matricula;
	}
	
	public String toString() {
		return this.matricula  + " - " + this.nome + " - " + this.curso;
	}
	
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if (!this.equals(obj.getClass()))
			return false;
		Aluno aln = (Aluno) obj;
		if (!this.matricula.equals(aln.matricula))
			return false;
		
		return true;
	} 
	
	public int hashCode() {
		return this.matricula.hashCode();
	}
}
