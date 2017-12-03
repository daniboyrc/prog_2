package alunos;

/**
 * Classe que representa um aluno.
 * 
 * @author daniel coura
 */
public class Aluno {
	
	private String matricula;
	private String nome;
	private String curso;
	
	/**
	 * Constroi um aluno a partir da matrícula, nome e curso.
	 * 
	 * @param matrícula a matrícula do aluno
	 * @param nome o nome do aluno
	 * @param curso o curso do aluno
	 */
	public Aluno(String matricula, String nome, String curso) {
		if (matricula == null || nome == null || curso == null) {
			throw new IllegalArgumentException("Valor inválido!");
		} else if (matricula.trim().equals("") || nome.trim().equals("") || curso.trim().equals("")) {
			throw new IllegalArgumentException("Valor inválido!");
		}
		this.nome = nome;
		this.matricula = matricula;
		this.curso = curso;
	}
	
	/**
	 * Retorna a representação em String do aluno. Segue o formato
	 * MATRÍCULA - NOME - CURSO
	 * 
	 * @return a String que representa o objeto do tipo Aluno
	 */
	public String toString() {
		return this.matricula  + " - " + this.nome + " - " + this.curso;
	}
	
	/**
	 * Compara se dois alunos. Dois alunos são iguais se tiverem a mesma matrícula.
	 * 
	 * @return a um booleano indicando se os alunos são iguais
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	} 
	
	/**
	 * Retorna a representação em Inteiro do aluno.
	 * 
	 * @return o Inteiro que representa o objeto do tipo Aluno
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}
}
