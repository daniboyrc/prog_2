package agenda;

/**
 * Classe que representa um contato.
 */
public class Contato {
	private String nome;
	private String sobrenome;
	private String telefone;
	
	/**
	 * Constroi um contato a partir do nome, sobrenome e telefone.
	 * 
	 * @param nome o nome do contato
	 * @param sobrenome o sobrenome do contato
	 * @param telefone o telefone do contato
	 */
	public Contato(String nome, String sobrenome, String telefone) {
		if (nome == null || sobrenome == null || telefone == null) {
			throw new NullPointerException("Passado valor nulo");
		}
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
	}
	
	/**
	 * Retorna a representacao em String do contato. Segue o formato
	 * NOME SOBRENOME - TELEFONE
	 * 
	 * @return a String que representa o objeto do tipo Contato
	 */
	public String toString() {
		return this.nome + " " + this.sobrenome + " - " + this.telefone;
	}
	
	/**
	 * Verifica se dois contatos sao iguais.
	 * 
	 * @return um booleano que sera true caso os contatos sejam iguais
	 */
	@Override
	public boolean equals(Object obj) {
		if ((obj instanceof Contato) && this.equals(((Contato) obj))) {
			return true;
		}
		return false;
	}
	
	/**
	 * Retorna um inteiro que identifica o contato, gerado atraves do nome
	 * do contato.
	 * 
	 * @return um inteiro que identifica o contato
	 */
	@Override
	public int hashCode() {
		return this.nome.hashCode();
	}
}
