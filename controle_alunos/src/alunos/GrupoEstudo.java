package alunos;
import java.util.HashSet;

/**
 * Classe que representa um grupo de estudo composto por alunos cadastrados.
 * 
 * @author daniel coura
 */
public class GrupoEstudo {
	
	private String nome;
	private HashSet<Aluno> alunos;
	
	/**
	 * Constrói um grupo de estudo a partir do nome.
	 * 
	 * @param nome o nome do grupo
	 */
	public GrupoEstudo(String nome) {
		if (nome == null || nome.trim().equals("")) {
			throw new IllegalArgumentException("Valor inválido!");
		}
		this.nome = nome;
		this.alunos = new HashSet<Aluno>();
	}
	
	/**
	 * Adiciona aluno ao grupo de estudo.
	 * 
	 * @param anl o aluno que será adicionado ao grupo de estudo
	 */
	public void adicionaAluno(Aluno aln) {
		this.alunos.add(aln);
	}
	
	/**
	 * Retorna a lista de alunos que estão no grupo de estudo.
	 * 
	 * @return a lista de alunos no grupo de estudo
	 */
	public String listaGrupo() {
		String lista = "";
		for (Aluno aln : alunos) {
			lista += "* " + aln.toString() + System.lineSeparator();
		}
		return lista;
	}
	
	/**
	 * Compara dois grupos de estudo. Dois grupos são iguais
	 * se tiverem o mesmo nome (case insensitive).
	 * 
	 * @return um booleano indicando se os grupos são iguais
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GrupoEstudo other = (GrupoEstudo) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.toLowerCase().equals(other.nome.toLowerCase()))
			return false;
		return true;
	}
	
	/**
	 * Retorna representação numérica do grupo de estudo.
	 * 
	 * @return a representação em Inteiro do grupo
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	
	/**
	 * Retorna representação numérica do grupo de estudo. Segue o formato:
	 * NOME_DO_GRUPO:
	 * ALUNO1
	 * ALUNO2
	 * ...
	 * 
	 * @return a representação em Inteiro do grupo
	 */
	public String toString() {
		return this.nome + ":\n" + this.listaGrupo();
	}
}
