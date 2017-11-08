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
}
