package coisa;


/**
 * Representacao da saude de um aluno.
 * 
 * @author Daniel Coura
 */
public class Saude {
	private String saudeFisica;
	private String saudeMental;
	private String emoji = "";
	
	/**
	 * Constroi a saude. Tanto a saude mental com a fisica
	 * sao por padrao "boa".
	 */
	public Saude() {
		this.saudeFisica = "boa";
		this.saudeMental = "boa";		
	}
	
	/**
	 * Define a saude mental do aluno. Pode ser
	 * "boa", "ok" ou "fraca".
	 * 
	 * @param valor a saude mental do aluno
	 */
	public void defineSaudeMental(String valor) {
		this.saudeMental = valor;
		this.emoji = "";
	}
	
	/**
	 * Define a saude fisica do aluno. Pode ser
	 * "boa", "ok" ou "fraca".
	 * 
	 * @param valor a saude fisica do aluno
	 */
	public void defineSaudeFisica(String valor) {
		this.saudeFisica = valor;
		this.emoji = "";
	}
	
	/**
	 * Define emoji que representa o sentimento do aluno.
	 * 
	 * @param valor um emoji representando o sentimento do aluno
	 */
	public void definirEmoji(String valor) {
		this.emoji = valor;
	}
	
	/**
	 * Retorna a saude de forma geral do aluno. Tem como criterios
	 * a saude fisica e a saude mental.
	 * 
	 * @return uma String representando a saude do aluno de forma geral
	 */
	public String geral() {
		if (this.saudeFisica.equals("boa") && this.saudeMental.equals("boa")) {
			return "boa" + this.emoji;
		}
		else if (this.saudeFisica != this.saudeMental) {
			return "ok" + this.emoji;
		}
		else {
			return "fraca" + this.emoji;
		}
	}
}
